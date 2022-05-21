package com.luxcar;

import static com.luxcar.configurations.ApplicationProperties.CONTEXT;
import static com.luxcar.configurations.ApplicationProperties.DATABASE_OPEN_HELPER;
import static com.luxcar.configurations.ApplicationProperties.SHARED_PREFERENCES;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.luxcar.configurations.DatabaseOpenHelper;
import com.luxcar.utillities.ImageHandler;

public class MainActivity extends AppCompatActivity {

    private AssetManager assetManager;
    private ProgressBar pbLoading;
    private ImageView ivCarAnimation;
    private int imageCarAnimationCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configure();

        DATABASE_OPEN_HELPER.onUpgrade(DATABASE_OPEN_HELPER.getWritableDatabase(), 4, 5);
//        DATABASE_OPEN_HELPER.onCreate(DATABASE_OPEN_HELPER.getWritableDatabase());

        createComponents();
        progressBarAnimation();
    }

    private void configure() {
        CONTEXT = this;
        DATABASE_OPEN_HELPER = new DatabaseOpenHelper(this);
        SHARED_PREFERENCES = getSharedPreferences("preferenceFile", Context.MODE_PRIVATE);
    }

    private void createComponents() {
        assetManager = this.getAssets();
        pbLoading = findViewById(R.id.pbLoading);
        ivCarAnimation = findViewById(R.id.ivCarAnimation);
        imageCarAnimationCurrent = 1;
    }

    private void progressBarAnimation() {
        new CountDownTimer(3000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                pbLoading.setProgress(Math.toIntExact(100 - millisUntilFinished / 30));
                ivCarAnimation.setImageBitmap(
                        ImageHandler.instance()
                                .getImage("images/common/vehicle_" + imageCarAnimationCurrent + ".png"));
                if (imageCarAnimationCurrent == 5) {
                    imageCarAnimationCurrent = 1;
                } else {
                    imageCarAnimationCurrent++;
                }
            }

            @Override
            public void onFinish() {
                Log.e("Progress: ", "done");
            }
        }.start();
    }
}
