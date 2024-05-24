package com.att.tdp.bisbis10.order;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrderDTO {
    @NotNull(message = "restaurantId is required")
    @Min(value = 1, message = "restaurantId must be at least 1")
    private Long restaurantId;

    @Valid
    @NotEmpty(message = "orderItems is required and must contain at least 1 order item")
    private List<OrderItemDTO> orderItems;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }
}
