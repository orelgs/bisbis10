package com.att.tdp.bisbis10.rating;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RatingDTO {
    @NotNull(message = "restaurantId is required")
    @Min(value = 1, message = "restaurantId must be at least 1")
    private Long restaurantId;

    @NotNull(message = "rating is required")
    @Min(value = 0, message = "rating must be at least 0")
    @Max(value = 5, message = "rating can be a max of 5")
    private Float rating;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Float getRating() {
        return rating;
    }
}
