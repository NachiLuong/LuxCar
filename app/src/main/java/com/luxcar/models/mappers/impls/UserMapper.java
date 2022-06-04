package com.luxcar.models.mappers.impls;

import android.database.Cursor;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.User;
import com.luxcar.models.mappers.ApplicationMapper;
import com.luxcar.models.types.Gender;
import com.luxcar.models.types.Role;
import com.luxcar.models.types.Status;

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
                    .email(cursor.getString(1))
                    .password(cursor.getString(2))
                    .name(cursor.getString(3))
                    .gender(Gender.valueOf(cursor.getString(4)))
                    .dob(Timestamp.valueOf("2021-03-24 16:48:05.591"))
                    .phone(cursor.getString(6))
                    .role(Role.valueOf(cursor.getString(7)))
                    .status(Status.valueOf(cursor.getString(8)))
                    .address(cursor.getString(9))
                    .createdDate(Timestamp.valueOf("2021-03-24 16:48:05.591"))
                    .createdBy(cursor.getString(11))
                    .modifiedDate(Timestamp.valueOf("2021-03-24 16:48:05.591"))
                    .modifiedBy(cursor.getString(13))
//                    .bills(BillRepository.instance().findAll("user_id = ?", new String[]{String.valueOf(cursor.getString(0))}))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


