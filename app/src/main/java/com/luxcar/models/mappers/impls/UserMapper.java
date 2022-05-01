package com.luxcar.models.mappers.impls;

import android.database.Cursor;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.User;
import com.luxcar.models.mappers.ApplicationMapper;
import com.luxcar.models.types.Gender;
import com.luxcar.models.types.Role;
import com.luxcar.models.types.Status;
import com.luxcar.repositories.impls.BillRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class UserMapper implements ApplicationMapper<User> {

    private static UserMapper userMapper = null;

    @NonNull
    public static UserMapper instance() {
        if (!Optional.ofNullable(userMapper).isPresent()) {
            userMapper = new UserMapper();
        }
        return userMapper;
    }

    @Override
    public User mapper(@NonNull Cursor cursor) {
        try {
            return User.builder()
                    .id(cursor.getInt(0))
                    .username(cursor.getString(1))
                    .password(cursor.getString(2))
                    .gender(Gender.valueOf(cursor.getString(3)))
                    .dob(Timestamp.valueOf(cursor.getString(4)))
                    .phone(cursor.getString(5))
                    .role(Role.valueOf(cursor.getString(6)))
                    .status(Status.valueOf(cursor.getString(7)))
                    .location(cursor.getString(8))
                    .bills(BillRepository.instance().findAll("user_id = ?", new String[]{String.valueOf(cursor.getString(0))}))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}
