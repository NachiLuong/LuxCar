package com.luxcar.models.mappers.impls;

import android.database.Cursor;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.Car;
import com.luxcar.models.mappers.ApplicationMapper;
import com.luxcar.repositories.impls.BrandRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class CarMapper implements ApplicationMapper<Car> {

    private static CarMapper carMapper = null;

    @NonNull
    public static CarMapper instance() {
        if (!Optional.ofNullable(carMapper).isPresent()) {
            carMapper = new CarMapper();
        }
        return carMapper;
    }

    @Override
    public Car mapper(@NonNull Cursor cursor) {
        try {
            return Car.builder()
                    .id(cursor.getInt(0))
                    .name(cursor.getString(1))
                    .description(cursor.getString(2))
                    .price(cursor.getDouble(3))
                    .availableSince(Timestamp.valueOf(cursor.getString(4)))
                    .photo(cursor.getBlob(5))
                    .mph(cursor.getDouble(6))
                    .maxSpeed(cursor.getDouble(7))
                    .brand(BrandRepository.instance().findOne(cursor.getInt(8)))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}
