package com.att.tdp.bisbis10.exception;

public class DishNotFoundException extends RuntimeException {
    private static final String errorMessage = "Dish with ID %d not found for restaurant with ID %d";

    public DishNotFoundException(Long dishId, long restaurantId) {
        super(String.format(errorMessage, dishId, restaurantId));
    }
}
