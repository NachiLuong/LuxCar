package com.luxcar.services;

import androidx.annotation.NonNull;

import java.util.Optional;

public class CarService {

    private static CarService carService = null;

    @NonNull
    public static CarService instance() {
        if (!Optional.ofNullable(carService).isPresent()) {
            carService = new CarService();
        }
        return carService;
    }

}
