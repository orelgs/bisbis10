package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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

    @PostMapping
    public ResponseEntity<Void> addRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO) {
        restaurantService.addRestaurant(restaurantDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRestaurantById(@PathVariable long id, @RequestBody RestaurantDTO restaurantDTO) {
        restaurantService.updateRestaurantById(id, restaurantDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
