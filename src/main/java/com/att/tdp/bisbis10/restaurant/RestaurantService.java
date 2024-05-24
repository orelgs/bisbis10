package com.att.tdp.bisbis10.restaurant;

import java.util.List;

public interface RestaurantService {
    List<RestaurantNoDishesProjection> getAllRestaurants();

    List<RestaurantNoDishesProjection> getAllRestaurantsByCuisine(String cuisine);

    Restaurant getRestaurantById(long id);

    void addRestaurant(RestaurantDTO restaurantDTO);

    void updateRestaurantById(long id, RestaurantDTO restaurantDTO);

    void deleteRestaurantById(long id);
}
