package com.att.tdp.bisbis10.dish;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.att.tdp.bisbis10.restaurant.Restaurant;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllDishesByRestaurant(Restaurant restaurant);
}
