package com.luxcar.services;

import androidx.annotation.NonNull;

import java.util.Optional;

public class BillService {

    private static BillService billService = null;

    @NonNull
    public static BillService instance() {
        if (!Optional.ofNullable(billService).isPresent()) {
            billService = new BillService();
        }
        return billService;
    }
}
