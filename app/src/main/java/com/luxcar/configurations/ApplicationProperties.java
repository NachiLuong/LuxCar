package com.luxcar.configurations;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationProperties {
    @SuppressLint("StaticFieldLeak")
    public static Context CONTEXT;
    public static DatabaseOpenHelper DATABASE_OPEN_HELPER;
    public static SharedPreferences SHARED_PREFERENCES;

    //frament admin
    public static final int ADMIN_FRAGMENT_BRAND =1;
    public static final int ADMIN_FRAGMENT_CAR =2;
    public static final int ADMIN_FRAGMENT_CHANGEPASS =3;
    public static final int ADMIN_FRAGMENT_USER =4;
    public static final int ADMIN_FRAGMENT_WAREHOUSE =5;
}