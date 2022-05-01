package com.luxcar.models.entities;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private Integer quantity;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp modifiedDate;
    private String modifiedBy;

    private Car car;

    @NonNull
    public ContentValues contentValues() {
        ContentValues values = new ContentValues();
        values.put("quantity", quantity);
        values.put("car_id", car.getId());
        return values;
    }
}
