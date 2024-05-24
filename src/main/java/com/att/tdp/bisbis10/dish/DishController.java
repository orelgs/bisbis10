package com.att.tdp.bisbis10.dish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishesByRestaurantId(@PathVariable("id") long restaurantId) {
        List<Dish> dishes = dishService.getAllDishesByRestaurantId(restaurantId);

        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addDishByRestaurantId(@PathVariable("id") long restaurantId, @Valid @RequestBody DishDTO dishDTO) {
        dishService.addDishByRestaurantId(restaurantId, dishDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Void> updateDishByRestaurantIdAndDishId(@PathVariable("id") long restaurantId, @PathVariable long dishId, 
                                                                                                @RequestBody DishDTO dishDTO) {
        dishService.updateDishByRestaurantIdAndDishId(restaurantId, dishId, dishDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDishByRestaurantIdAndDishId(@PathVariable("id") long restaurantId, @PathVariable long dishId) {
        dishService.deleteDishByRestaurantIdAndDishId(restaurantId, dishId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
