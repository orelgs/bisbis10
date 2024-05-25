package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.exception.RestaurantNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantNoDishesProjection> getAllRestaurants() {
        return restaurantRepository.findAllProjectedBy();
    }

    @Override
    public List<RestaurantNoDishesProjection> getAllRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findAllProjectedByCuisinesContaining(cuisine);
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.findById(id)
                                   .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @Override
    public void addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = Restaurant.createRestaurantFromDTO(restaurantDTO);

        restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public void updateRestaurantById(long id, RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                                                    .orElseThrow(() -> new RestaurantNotFoundException(id));


        if (restaurantDTO.getName() != null) {
            restaurant.setName(restaurantDTO.getName());
        }

        if (restaurantDTO.isKosher() != null) {
            restaurant.setKosher(restaurantDTO.isKosher());
        }

        if (restaurantDTO.getCuisines() != null) {
            restaurant.setCuisines(restaurantDTO.getCuisines());
        }

        restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public void deleteRestaurantById(long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                                                    .orElseThrow(() -> new RestaurantNotFoundException(id));

        restaurantRepository.delete(restaurant);
    }
}
