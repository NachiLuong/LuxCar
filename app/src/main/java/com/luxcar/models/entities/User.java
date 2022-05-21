package com.luxcar.models.entities;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.luxcar.models.types.Gender;
import com.luxcar.models.types.Role;
import com.luxcar.models.types.Status;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String email;
    private String password;
    private String name;
    private Gender gender;
    private Timestamp dob;
    private String phone;
    private Role role;
    private Status status;
    private String address;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp modifiedDate;
    private String modifiedBy;

    private List<Bill> bills;

    @NonNull
    public ContentValues contentValues() {
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        values.put("name", name);
        values.put("gender", gender.toString());
        values.put("dob", dob.toString());
        values.put("role", role.toString());
        values.put("status", status.toString());
        values.put("address", address);
        values.put("phone", phone);
        return values;
    }
}
