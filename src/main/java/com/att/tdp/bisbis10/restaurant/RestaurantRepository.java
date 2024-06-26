package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<RestaurantNoDishesProjection> findAllProjectedBy();

    List<RestaurantNoDishesProjection> findAllProjectedByCuisinesContaining(String cuisine);
}
