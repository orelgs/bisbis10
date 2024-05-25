package com.att.tdp.bisbis10.restaurant;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "averageRating", "isKosher", "cuisines"})
public interface RestaurantNoDishesProjection {
    Long getId();
    
    String getName();

    float getAverageRating();

    boolean getIsKosher();

    Set<String> getCuisines();
}
