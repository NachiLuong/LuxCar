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
public class Bill {

    private Integer id;
    private Integer quantity;
    private Double price;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp modifiedDate;
    private String modifiedBy;

    private User user;
    private Car car;

    @NonNull
    public ContentValues contentValues() {
        ContentValues values = new ContentValues();
        values.put("quantity", quantity);
        values.put("price", price);
        values.put("user_id", user.getId());
        values.put("car_id", car.getId());
        return values;
    }
}
