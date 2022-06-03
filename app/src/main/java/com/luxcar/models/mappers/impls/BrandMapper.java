package com.luxcar.models.mappers.impls;

import android.database.Cursor;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.Brand;
import com.luxcar.models.mappers.ApplicationMapper;

import java.sql.Timestamp;
import java.util.Optional;

public class BrandMapper implements ApplicationMapper<Brand> {

    private static BrandMapper brandMapper = null;

    @NonNull
    public static BrandMapper instance() {
        if (!Optional.ofNullable(brandMapper).isPresent()) {
            brandMapper = new BrandMapper();
        }
        return brandMapper;
    }

    @Override
    public Brand mapper(@NonNull Cursor cursor) {
        try {
            return Brand.builder()
                    .id(cursor.getInt(0))
                    .name(cursor.getString(1))
                    .description(cursor.getString(2))
                    .logo(cursor.getBlob(3))
                    .createdDate(Timestamp.valueOf("2021-03-24 16:48:05.591"))
                    .createdBy(cursor.getString(5))
                    .modifiedDate(Timestamp.valueOf("2021-03-24 16:48:05.591"))
                    .modifiedBy(cursor.getString(7))
//                    .cars(CarRepository.instance().findAll("brand_id = ?", new String[]{String.valueOf(cursor.getInt(0))}))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
