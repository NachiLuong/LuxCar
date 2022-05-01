package com.luxcar.repositories.impls;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.luxcar.configurations.ApplicationProperties;
import com.luxcar.models.mappers.ApplicationMapper;
import com.luxcar.repositories.IRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Repository<T> implements IRepository<T> {

    @Override
    public List<T> query(@NonNull String sql, @NonNull ApplicationMapper<T> applicationMapper, String[] selectionArgs) {
        List<T> results = new ArrayList<>();
        try (SQLiteDatabase sqLiteDatabase = ApplicationProperties.DATABASE_OPEN_HELPER.getWritableDatabase()) {
            Cursor cursor = sqLiteDatabase.rawQuery(sql, selectionArgs);
            while (cursor.moveToNext()) {
                results.add(applicationMapper.mapper(cursor));
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return results;
    }

    @Override
    public T findOne(@NonNull String table, @NonNull ApplicationMapper<T> applicationMapper, @NonNull Integer id) {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";
        List<T> results = query(sql, applicationMapper, new String[]{id.toString()});
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            throw new IllegalArgumentException("Not found!");
        }
    }

    @Override
    public List<T> findAll(@NonNull String table, @NonNull ApplicationMapper<T> applicationMapper) {
        String sql = "SELECT * FROM " + table;
        return query(sql, applicationMapper, null);
    }

    @Override
    public List<T> findAll(@NonNull String table, @NonNull ApplicationMapper<T> applicationMapper, String whereClause, String[] whereArgs) {
        String sql = "SELECT * FROM " + table + " WHERE " + whereClause;
        return query(sql, applicationMapper, whereArgs);
    }

    @Override
    public Integer insert(@NonNull String table, @NonNull ContentValues values) {
        try (SQLiteDatabase sqLiteDatabase = ApplicationProperties.DATABASE_OPEN_HELPER.getWritableDatabase()) {
            return (Integer) (int) sqLiteDatabase.insert(table, "", values);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }

    @Override
    public Integer update(@NonNull String table, @NonNull ContentValues values, String whereClause, String[] whereArgs) {
        try (SQLiteDatabase sqLiteDatabase = ApplicationProperties.DATABASE_OPEN_HELPER.getWritableDatabase()) {
            return sqLiteDatabase.update(table, values, whereClause, whereArgs);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }

    @Override
    public Integer delete(@NonNull String table, String whereClause, String[] whereArgs) {
        try (SQLiteDatabase sqLiteDatabase = ApplicationProperties.DATABASE_OPEN_HELPER.getWritableDatabase()) {
            return sqLiteDatabase.delete(table, whereClause, whereArgs);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public Consumer<ContentValues> integrityCreated = values -> {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        values.put("created_date", String.valueOf(now));
//        values.put("created_by", ApplicationProperties.SHARED_PREFERENCES.getString("username", ""));
        values.put("created_by", "user 1");
        values.put("modified_date", String.valueOf(now));
//        values.put("modified_by", ApplicationProperties.SHARED_PREFERENCES.getString("username", ""));
        values.put("modified_by", "user 1");
    };

    public Consumer<ContentValues> integrityModified = values -> {
        values.put("modified_date", (new Timestamp(System.currentTimeMillis()).toString()));
//        values.put("modified_by", ApplicationProperties.SHARED_PREFERENCES.getString("username", ""));
        values.put("modified_by", "user 1");
    };
}

