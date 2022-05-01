package com.luxcar.services;

import androidx.annotation.NonNull;

import java.util.Optional;

public class BrandService {

    private static BrandService brandService = null;

    @NonNull
    public static BrandService instance() {
        if (!Optional.ofNullable(brandService).isPresent()) {
            brandService = new BrandService();
        }
        return brandService;
    }
}
