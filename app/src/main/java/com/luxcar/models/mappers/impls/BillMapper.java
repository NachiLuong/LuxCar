package com.luxcar.models.mappers.impls;

import android.database.Cursor;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.Bill;
import com.luxcar.models.mappers.ApplicationMapper;
import com.luxcar.repositories.impls.CarRepository;
import com.luxcar.repositories.impls.UserRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class BillMapper implements ApplicationMapper<Bill> {

    private static BillMapper billMapper = null;

    @NonNull
    public static BillMapper instance() {
        if (!Optional.ofNullable(billMapper).isPresent()) {
            billMapper = new BillMapper();
        }
        return billMapper;
    }

    @Override
    public Bill mapper(@NonNull Cursor cursor) {
        try {
            return Bill.builder()
                    .id(cursor.getInt(0))
                    .quantity(cursor.getInt(1))
                    .price(cursor.getDouble(2))
                    .createdDate(Timestamp.valueOf("2021-03-24 16:48:05.591"))
                    .createdBy(cursor.getString(5))
                    .modifiedDate(Timestamp.valueOf("2021-03-24 16:48:05.591"))
                    .modifiedBy(cursor.getString(7))
                    .user(UserRepository.instance().findOne(cursor.getInt(8)))
                    .car(CarRepository.instance().findOne(cursor.getInt(9)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

