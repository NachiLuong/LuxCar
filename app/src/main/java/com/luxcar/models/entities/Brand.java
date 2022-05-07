package com.luxcar.models.entities;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private Integer id;
    private String name;
    private String description;
    private byte[] logo;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp modifiedDate;
    private String modifiedBy;

    private List<Car> cars;

    @NonNull
    public ContentValues contentValues() {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("description", description);
        values.put("logo", logo);
        return values;
    }
}
