package com.luxcar.repositories.impls;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.User;
import com.luxcar.models.entities.Warehouse;
import com.luxcar.models.mappers.impls.WarehouseMapper;

import java.util.List;
import java.util.Optional;

public class WarehouseRepository extends Repository<Warehouse> {
    private static final String table = "warehouse";
    private static final WarehouseMapper mapper = WarehouseMapper.instance();
    private static WarehouseRepository warehouseRepository = null;

    @NonNull
    public static WarehouseRepository instance() {
        if (!Optional.ofNullable(warehouseRepository).isPresent()) {
            warehouseRepository = new WarehouseRepository();
        }
        return warehouseRepository;
    }

    public List<Warehouse> query(@NonNull String sql, String[] selectionArgs) {
        return super.query(sql, mapper, selectionArgs);
    }

    public Warehouse findOne(@NonNull Integer id) {
        List<Warehouse> results = super.query("SELECT * FROM warehouse WHERE car_id = ?", mapper, new String[]{id.toString()});
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            throw new IllegalArgumentException("Not found!");
        }
    }

    public List<Warehouse> findAll() {
        return super.findAll(table, mapper);
    }

    public List<Warehouse> findAll(String whereClause, String[] whereArgs) {
        return super.findAll(table, mapper, whereClause, whereArgs);
    }

    public Integer insert(@NonNull User user) {
        ContentValues values = user.contentValues();
        super.integrityCreated.accept(values);
        return super.insert(table, values);
    }

    public Integer update(@NonNull User user, String whereClause, String[] whereArgs) {
        ContentValues values = user.contentValues();
        super.integrityModified.accept(values);
        return super.update(table, values, whereClause, whereArgs);
    }

    public Integer delete(String whereClause, String[] whereArgs) {
        return super.delete(table, whereClause, whereArgs);
    }
}
