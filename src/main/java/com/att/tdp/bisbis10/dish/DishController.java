package com.att.tdp.bisbis10.dish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
