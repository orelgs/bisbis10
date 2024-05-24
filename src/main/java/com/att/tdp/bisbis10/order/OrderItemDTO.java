package com.att.tdp.bisbis10.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderItemDTO {
    @NotNull(message = "dishId is required")
    @Min(value = 1, message = "dishId must be at least 1")
    private Long dishId;

    @NotNull(message = "amount is required")
    @Min(value = 1, message = "amount must be at least 1")
    private Integer amount;

    public Long getDishId() {
        return dishId;
    }

    public Integer getAmount() {
        return amount;
    }
}
