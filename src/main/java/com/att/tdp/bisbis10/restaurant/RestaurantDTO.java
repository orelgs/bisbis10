package com.att.tdp.bisbis10.restaurant;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RestaurantDTO {
    @NotBlank(message = "name is required and cannot be blank")
    private String name;

    @NotNull(message = "isKosher is required")
    private Boolean isKosher;

    @NotEmpty(message = "cuisines is required and must contain at least 1 cuisine")
    private Set<@NotBlank(message = "Cuisine name cannot be blank") String> cuisines;

    public String getName() {
        return name;
    }

    public Boolean isKosher() {
        return isKosher;
    }

    public Set<String> getCuisines() {
        return cuisines;
    }
}
