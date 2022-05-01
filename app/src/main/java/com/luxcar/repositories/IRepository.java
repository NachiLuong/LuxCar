package com.luxcar.repositories;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.luxcar.models.mappers.ApplicationMapper;

import java.util.List;

public interface IRepository<T> {

    /* Return list result and mapping to T Object */
    List<T> query(@NonNull String table, @NonNull ApplicationMapper<T> applicationMapper, String[] selectionArgs);

    /* Return T Object by id */
    T findOne(@NonNull String table, @NonNull ApplicationMapper<T> applicationMapper, @NonNull Integer id);

    /* Return list result all records of table and mapping to T object */
    List<T> findAll(@NonNull String table, @NonNull ApplicationMapper<T> applicationMapper);

    /* Return list result all records of table and mapping to T object by where conditions */
    /* Where clause example: user_id = ?, brand_id = ? */
    List<T> findAll(@NonNull String table, @NonNull ApplicationMapper<T> applicationMapper, String whereClause, String[] whereArgs);

    /* Return the row ID of the newly inserted row, or -1 if an error occurred */
    Integer insert(@NonNull String table, @NonNull ContentValues values);

    /* Return the number of rows affected */
    Integer update(@NonNull String table, @NonNull ContentValues values, String whereClause, String[] whereArgs);

    /* Return the number of rows affected if a whereClause is passed in, 0 otherwise. To remove all rows and get a count pass "1" as the whereClause. */
    Integer delete(@NonNull String table, String whereClause, String[] whereArgs);
}
