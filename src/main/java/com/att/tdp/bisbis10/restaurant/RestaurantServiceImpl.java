package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.exception.RestaurantNotFoundException;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getAllRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findAllByCuisinesContaining(cuisine);
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.findById(id)
                                   .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @Override
    public void addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();

        restaurant.setName(restaurantDTO.getName());
        restaurant.setKosher(restaurantDTO.isKosher());
        restaurant.setCuisines(restaurantDTO.getCuisines());

        restaurantRepository.save(restaurant);
    }
}
