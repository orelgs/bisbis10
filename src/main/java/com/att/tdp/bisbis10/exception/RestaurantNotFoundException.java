package com.att.tdp.bisbis10.exception;

public class RestaurantNotFoundException extends RuntimeException {
    private static final String errorMessage = "Restaurant with ID %d not found";

    public RestaurantNotFoundException(long id) {
        super(String.format(errorMessage, id));
    }
}
