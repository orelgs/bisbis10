package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.validator.PartialUpdateValidator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private PartialUpdateValidator validator;

    @GetMapping
    public ResponseEntity<List<RestaurantNoDishesProjection>> getAllRestaurants(@RequestParam(required = false) String cuisine) {
        List<RestaurantNoDishesProjection> restaurants;
        
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
    public ResponseEntity<Void> updateRestaurantById(@PathVariable long id, @Valid @RequestBody RestaurantDTO restaurantDTO, 
                                                     BindingResult bindingResult) {
        validator.validate(restaurantDTO, bindingResult);
        restaurantService.updateRestaurantById(id, restaurantDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantById(@PathVariable long id) {
        restaurantService.deleteRestaurantById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
