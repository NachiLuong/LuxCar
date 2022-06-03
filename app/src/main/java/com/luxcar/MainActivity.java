package com.luxcar;

import static com.luxcar.configurations.ApplicationProperties.CONTEXT;
import static com.luxcar.configurations.ApplicationProperties.DATABASE_OPEN_HELPER;
import static com.luxcar.configurations.ApplicationProperties.SHARED_PREFERENCES;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.luxcar.activities.admin.AdminActivity;
import com.luxcar.configurations.DatabaseOpenHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private AssetManager assetManager;
    private ProgressBar pbLoading;
    private ImageView ivCarAnimation;
    private int imageCarAnimationCurrent;
    int counter =0;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configure();

//        DATABASE_OPEN_HELPER.onUpgrade(DATABASE_OPEN_HELPER.getWritableDatabase(), 4, 5);
        DATABASE_OPEN_HELPER.onCreate(DATABASE_OPEN_HELPER.getWritableDatabase());
//
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

    private Bitmap getImageBitmap(@NonNull String path) {
        try {
            InputStream ip = assetManager.open(path);
            return BitmapFactory.decodeStream(ip);
        } catch (IOException e) {
            Log.e("Image", e.getMessage());
        }
        return null;
    }

    private void progressBarAnimation() {
        Timer timer = new Timer();
        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                counter++;
                pbLoading.setProgress(counter);
                ivCarAnimation.setImageBitmap(getImageBitmap("images/common/vehicle_" + imageCarAnimationCurrent + ".png"));
                if (imageCarAnimationCurrent == 5) {
                    imageCarAnimationCurrent = 1;
                } else {
                    imageCarAnimationCurrent ++;
                }
                if(counter==100){
                    timer.cancel();
                    Intent intent= new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.schedule(timerTask,100,100);

    }
}
