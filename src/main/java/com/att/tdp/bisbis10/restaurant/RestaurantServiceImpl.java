package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.exception.PartialUpdateValueNotValidException;
import com.att.tdp.bisbis10.exception.RestaurantNotFoundException;

import jakarta.transaction.Transactional;

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
        Restaurant restaurant = Restaurant.createRestaurantFromDTO(restaurantDTO);

        restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public void updateRestaurantById(long id, RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                                                    .orElseThrow(() -> new RestaurantNotFoundException(id));


        if (restaurantDTO.getName() != null) {
            if (restaurantDTO.getName().isBlank()) {
                throw new PartialUpdateValueNotValidException("name cannot be blank");
            }

            restaurant.setName(restaurantDTO.getName());
        }

        if (restaurantDTO.isKosher() != null) {
            restaurant.setKosher(restaurantDTO.isKosher());
        }

        if (restaurantDTO.getCuisines() != null) {
            if (restaurantDTO.getCuisines().isEmpty()) {
                throw new PartialUpdateValueNotValidException("cuisines must contain at least 1 cuisine");
            }

            for (String cuisine : restaurantDTO.getCuisines()) {
                if (cuisine.isBlank()) {
                    throw new PartialUpdateValueNotValidException("Cuisine name cannot be blank");
                }
            }

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
