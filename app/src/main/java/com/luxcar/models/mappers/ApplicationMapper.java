package com.luxcar.models.mappers;

import android.database.Cursor;

import androidx.annotation.NonNull;

public interface ApplicationMapper<T> {
    T mapper(@NonNull Cursor cursor);
}
