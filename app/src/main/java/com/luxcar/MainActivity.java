package com.luxcar;

import static com.luxcar.configurations.ApplicationProperties.CONTEXT;
import static com.luxcar.configurations.ApplicationProperties.DATABASE_OPEN_HELPER;
import static com.luxcar.configurations.ApplicationProperties.SHARED_PREFERENCES;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.luxcar.configurations.DatabaseOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configure();

        DATABASE_OPEN_HELPER.onUpgrade(DATABASE_OPEN_HELPER.getWritableDatabase(), 3, 4);
//        DATABASE_OPEN_HELPER.onCreate(DATABASE_OPEN_HELPER.getWritableDatabase());
    }

    void configure() {
        CONTEXT = this;
        DATABASE_OPEN_HELPER = new DatabaseOpenHelper(this);
        SHARED_PREFERENCES = getSharedPreferences("preferenceFile", Context.MODE_PRIVATE);
    }
}