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
public class Car {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Timestamp availableSince;
    private byte[] photo;
    private Double mph;
    private Double maxSpeed;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp modifiedDate;
    private String modifiedBy;

    private Brand brand;

    @NonNull
    public ContentValues contentValues() {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("description", description);
        values.put("price", price);
        values.put("available_since", availableSince.toString());
        values.put("photo", photo);
        values.put("mph", mph);
        values.put("max_speed", maxSpeed);
        values.put("brand_id", brand.getId());
        return values;
    }
}
