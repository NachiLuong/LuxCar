package com.luxcar.repositories.impls;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.Bill;
import com.luxcar.models.mappers.impls.BillMapper;

import java.util.List;
import java.util.Optional;

public class BillRepository extends Repository<Bill> {

    private static final String table = String.valueOf(Bill.class);
    private static final BillMapper mapper = BillMapper.instance();
    private static BillRepository billRepository = null;

    @NonNull
    public static BillRepository instance() {
        if (!Optional.ofNullable(billRepository).isPresent()) {
            billRepository = new BillRepository();
        }
        return billRepository;
    }

    public List<Bill> query(@NonNull String sql, String[] selectionArgs) {
        return super.query(sql, mapper, selectionArgs);
    }
    
    public Bill findOne(@NonNull Integer id) {
        return super.findOne(table, mapper, id);
    }

    public List<Bill> findAll() {
        return super.findAll(table, mapper);
    }

    public List<Bill> findAll(String whereClause, String[] whereArgs) {
        return super.findAll(table, mapper, whereClause, whereArgs);
    }

    public Integer insert(@NonNull Bill bill) {
        ContentValues values = bill.contentValues();
        super.integrityCreated.accept(values);
        return super.insert(table, values);
    }

    public Integer update(@NonNull Bill bill, String whereClause, String[] whereArgs) {
        ContentValues values = bill.contentValues();
        super.integrityModified.accept(values);
        return super.update(table, values, whereClause, whereArgs);
    }

    public Integer delete(String whereClause, String[] whereArgs) {
        return super.delete(table, whereClause, whereArgs);
    }
}
