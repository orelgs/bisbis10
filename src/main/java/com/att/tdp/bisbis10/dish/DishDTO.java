package com.att.tdp.bisbis10.dish;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DishDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Min(value = 0)
    private float price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
