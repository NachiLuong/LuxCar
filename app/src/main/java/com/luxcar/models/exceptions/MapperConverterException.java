package com.luxcar.models.exceptions;

import android.database.Cursor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapperConverterException extends Exception {

    private Cursor cursor;

    public MapperConverterException(Cursor cursor, String msg, Throwable cause) {
        super(msg, cause);
        this.cursor = cursor;
    }
}
