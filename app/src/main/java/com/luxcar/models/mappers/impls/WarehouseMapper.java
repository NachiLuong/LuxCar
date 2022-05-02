package com.luxcar.models.mappers.impls;

import android.database.Cursor;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.Warehouse;
import com.luxcar.models.mappers.ApplicationMapper;
import com.luxcar.repositories.impls.CarRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class WarehouseMapper implements ApplicationMapper<Warehouse> {

    private static WarehouseMapper warehouseMapper = null;

    @NonNull
    public static WarehouseMapper instance() {
        if (!Optional.ofNullable(warehouseMapper).isPresent()) {
            warehouseMapper = new WarehouseMapper();
        }
        return warehouseMapper;
    }

    @Override
    public Warehouse mapper(@NonNull Cursor cursor) {
        try {
            return Warehouse.builder()
                    .car(CarRepository.instance().findOne(cursor.getInt(0)))
                    .quantity(cursor.getInt(1))
                    .createdDate(Timestamp.valueOf(cursor.getString(2)))
                    .createdBy(cursor.getString(3))
                    .modifiedDate(Timestamp.valueOf(cursor.getString(4)))
                    .modifiedBy(cursor.getString(5))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}
