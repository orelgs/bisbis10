package com.att.tdp.bisbis10.dish;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DishDTO {
    @NotBlank(message = "name is required and cannot be blank")
    private String name;

    @NotBlank(message = "description is required and cannot be blank")
    private String description;

    @NotNull(message = "price is required")
    @Min(value = 0, message = "price must be at least 0")
    private Float price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }
}
