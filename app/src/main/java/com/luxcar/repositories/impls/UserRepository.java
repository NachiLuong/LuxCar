package com.luxcar.repositories.impls;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.User;
import com.luxcar.models.mappers.impls.UserMapper;

import java.util.List;
import java.util.Optional;

public class UserRepository extends Repository<User> {

    private static final String table = "user";
    private static final UserMapper mapper = UserMapper.instance();
    private static UserRepository userRepository = null;

    @NonNull
    public static UserRepository instance() {
        if (!Optional.ofNullable(userRepository).isPresent()) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public List<User> query(@NonNull String sql, String[] selectionArgs) {
        return super.query(sql, mapper, selectionArgs);
    }

    public User findOne(@NonNull Integer id) {
        return super.findOne(table, mapper, id);
    }

    public List<User> findAll() {
        return super.findAll(table, mapper);
    }

    public List<User> findAll(String whereClause, String[] whereArgs) {
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

    public User findByEmail(@NonNull String email, @NonNull String password) {
        List<User> result = this.query("SELECT * FROM user WHERE email = ? AND password", new String[]{email, password});
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }
    public Boolean findEmailExist(@NonNull String email) {
        List<User> result = this.query("SELECT name FROM user WHERE email = ?", new String[]{email});
        if (!result.isEmpty()) {
            return true;
        }
        return false;
    }
}
