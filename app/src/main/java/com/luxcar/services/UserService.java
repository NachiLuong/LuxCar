package com.luxcar.services;

import androidx.annotation.NonNull;

import java.util.Optional;

public class UserService {

    private static UserService userService = null;

    @NonNull
    public static UserService instance() {
        if (!Optional.ofNullable(userService).isPresent()) {
            userService = new UserService();
        }
        return userService;
    }

}
