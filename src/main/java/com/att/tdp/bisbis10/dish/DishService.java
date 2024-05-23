package com.att.tdp.bisbis10.dish;

import java.util.List;

import jakarta.validation.Valid;

public interface DishService {
    List<Dish> getAllDishesByRestaurantId(long restaurantId);

    void addDishByRestaurantId(long restaurantId, @Valid DishDTO dishDTO);

    void updateDishByRestaurantIdAndDishId(long restaurantId, long dishId, DishDTO dishDTO);

    void deleteDishByRestaurantIdAndDishId(long restaurantId, long dishId);
}
