package com.luxcar.configurations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.luxcar.constants.DATABASE;

import java.util.ResourceBundle;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = DATABASE.VERSION;
    private static final String DATABASE_NAME = DATABASE.NAME;
    private final ResourceBundle resourceBundleSchema = ResourceBundle.getBundle("schema");
    private final ResourceBundle resourceBundleData = ResourceBundle.getBundle("data");

    public DatabaseOpenHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_BRAND));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_CAR));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_USER));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_BILL));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.CREATE_WAREHOUSE));
        insertData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_WAREHOUSE));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_BILL));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_BRAND));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_CAR));
        sqLiteDatabase.execSQL(resourceBundleSchema.getString(DATABASE.DROP_USER));

        this.onCreate(sqLiteDatabase);
    }

    private void insertData(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(resourceBundleData.getString("insert_brands"));
        sqLiteDatabase.execSQL(resourceBundleData.getString("insert_cars"));
    }
}
