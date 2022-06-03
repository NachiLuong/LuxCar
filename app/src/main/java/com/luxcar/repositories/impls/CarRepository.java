package com.luxcar.repositories.impls;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.Car;
import com.luxcar.models.mappers.impls.CarMapper;

import java.util.List;
import java.util.Optional;

public class CarRepository extends Repository<Car> {

    private static final String table = "car";
    private static final CarMapper mapper = CarMapper.instance();
    private static CarRepository carRepository = null;

    @NonNull
    public static CarRepository instance() {
        if (!Optional.ofNullable(carRepository).isPresent()) {
            carRepository = new CarRepository();
        }
        return carRepository;
    }

    public List<Car> query(@NonNull String sql, String[] selectionArgs) {
        return super.query(sql, mapper, selectionArgs);
    }

    public Car findOne(@NonNull Integer id) {
        return super.findOne(table, mapper, id);
    }

    public List<Car> findAll() {
        return super.findAll(table, mapper);
    }

    public List<Car> findAll(String whereClause, String[] whereArgs) {
        return super.findAll(table, mapper, whereClause, whereArgs);
    }

    public Integer insert(@NonNull Car car) {
        ContentValues values = car.contentValues();
        super.integrityCreated.accept(values);
        return super.insert(table, values);
    }

    public Integer update(@NonNull Car car, String whereClause, String[] whereArgs) {
        ContentValues values = car.contentValues();
        super.integrityModified.accept(values);
        return super.update(table, values, whereClause, whereArgs);
    }

    public Integer delete(String whereClause, String[] whereArgs) {
        return super.delete(table, whereClause, whereArgs);
    }
}
