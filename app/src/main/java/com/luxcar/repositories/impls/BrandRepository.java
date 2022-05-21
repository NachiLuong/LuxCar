package com.luxcar.repositories.impls;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.Brand;
import com.luxcar.models.mappers.impls.BrandMapper;

import java.util.List;
import java.util.Optional;

public class BrandRepository extends Repository<Brand> {

    private static final String table = String.valueOf(Brand.class);
    private static final BrandMapper mapper = BrandMapper.instance();
    private static BrandRepository brandRepository = null;

    @NonNull
    public static BrandRepository instance() {
        if (!Optional.ofNullable(brandRepository).isPresent()) {
            brandRepository = new BrandRepository();
        }
        return brandRepository;
    }

    public List<Brand> query(@NonNull String sql, String[] selectionArgs) {
        return super.query(sql, mapper, selectionArgs);
    }

    public Brand findOne(@NonNull Integer id) {
        return super.findOne(table, mapper, id);
    }

    public List<Brand> findAll() {
        return super.findAll(table, mapper);
    }

    public List<Brand> findAll(String whereClause, String[] whereArgs) {
        return super.findAll(table, mapper, whereClause, whereArgs);
    }

    public Integer insert(@NonNull Brand brand) {
        ContentValues values = brand.contentValues();
        super.integrityCreated.accept(values);
        return super.insert(table, values);
    }

    public Integer update(@NonNull Brand brand, String whereClause, String[] whereArgs) {
        ContentValues values = brand.contentValues();
        super.integrityModified.accept(values);
        return super.update(table, values, whereClause, whereArgs);
    }

    public Integer delete(String whereClause, String[] whereArgs) {
        return super.delete(table, whereClause, whereArgs);
    }
}
