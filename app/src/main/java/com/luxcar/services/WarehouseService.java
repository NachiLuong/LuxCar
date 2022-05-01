package com.luxcar.services;

import androidx.annotation.NonNull;

import java.util.Optional;

public class WarehouseService {

    private static WarehouseService warehouseService = null;

    @NonNull
    public static WarehouseService instance() {
        if (!Optional.ofNullable(warehouseService).isPresent()) {
            warehouseService = new WarehouseService();
        }
        return warehouseService;
    }

}
