package com.luxcar.services;

import androidx.annotation.NonNull;

import com.luxcar.models.entities.User;
import com.luxcar.repositories.impls.UserRepository;

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

    public User isExist(@NonNull String email, @NonNull String password) {
        return UserRepository.instance().findByEmail(email, password);
    }
    public Boolean isEmailExist(@NonNull String email){
        return UserRepository.instance().findEmailExist(email);
    }
    public Integer addUser(User user){
        return UserRepository.instance().insert(user);
    }

}
