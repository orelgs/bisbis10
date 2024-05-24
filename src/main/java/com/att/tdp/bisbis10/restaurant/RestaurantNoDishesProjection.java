package com.att.tdp.bisbis10.restaurant;

import java.util.Set;

public interface RestaurantNoDishesProjection {
    Long getId();
    
    String getName();

    float getAverageRating();

    boolean getIsKosher();

    Set<String> getCuisines();
}
