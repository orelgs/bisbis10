package com.att.tdp.bisbis10.dish;

import java.util.List;

public interface DishService {
    List<Dish> getAllDishesByRestaurantId(long restaurantId);
}
