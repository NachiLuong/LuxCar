package com.luxcar.configurations;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;

import com.luxcar.constants.DATABASE;
import com.luxcar.models.entities.Brand;
import com.luxcar.repositories.impls.BrandRepository;

import java.util.ResourceBundle;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "luxcar";
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    public DatabaseOpenHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.CREATE_BRAND));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.CREATE_CAR));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.CREATE_USER));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.CREATE_BILL));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.CREATE_WAREHOUSE));
        insertData();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.DROP_WAREHOUSE));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.DROP_BILL));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.DROP_BRAND));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.DROP_CAR));
        sqLiteDatabase.execSQL(resourceBundle.getString(DATABASE.DROP_USER));

        this.onCreate(sqLiteDatabase);
    }
    private void insertData() {

        for (int i = 0; i < 10; i++) {
            Integer id = BrandRepository.instance().insert(
                    Brand.builder()
                            .name("brand " + i)
                            .description("description " + i)
                            .logo(new byte[9])
                            .build());


            Log.i("id", "done");
            Log.i("id: ", id.toString());
            Log.i("brand " + i, BrandRepository.instance().findOne(id).toString());
        }
    }
}
