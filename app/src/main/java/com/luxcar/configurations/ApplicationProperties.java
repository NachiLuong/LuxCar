package com.luxcar.configurations;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationProperties {
    @SuppressLint("StaticFieldLeak")
    public static Context CONTEXT;
    public static DatabaseOpenHelper DATABASE_OPEN_HELPER;
    public static SharedPreferences SHARED_PREFERENCES;
}