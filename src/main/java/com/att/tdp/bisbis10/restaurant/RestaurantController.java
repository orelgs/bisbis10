package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam(required = false) String cuisine) {
        List<Restaurant> restaurants;
        
        if (cuisine == null) {
            restaurants = restaurantService.getAllRestaurants();
        } else {
            restaurants = restaurantService.getAllRestaurantsByCuisine(cuisine);
        }

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
}
