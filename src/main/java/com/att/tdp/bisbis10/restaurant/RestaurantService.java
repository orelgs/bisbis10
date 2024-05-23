package com.att.tdp.bisbis10.restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();

    List<Restaurant> getAllRestaurantsByCuisine(String cuisine);
}
