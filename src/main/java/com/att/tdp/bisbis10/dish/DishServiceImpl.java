package com.att.tdp.bisbis10.dish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.att.tdp.bisbis10.exception.DishNotFoundException;
import com.att.tdp.bisbis10.exception.RestaurantNotFoundException;
import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.att.tdp.bisbis10.restaurant.RestaurantRepository;

import jakarta.validation.Valid;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Dish> getAllDishesByRestaurantId(long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                                                    .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

        return dishRepository.findAllDishesByRestaurant(restaurant);
    }

    @Override
    @Transactional
    public void addDishByRestaurantId(long restaurantId, @Valid DishDTO dishDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                                                    .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));
        Dish dish = Dish.createDishFromDTO(dishDTO);

        dish.setRestaurant(restaurant);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void updateDishByRestaurantIdAndDishId(long restaurantId, long dishId, DishDTO dishDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                                                    .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));
        Dish dish = dishRepository.findById(dishId)
                                  .orElseThrow(() -> new DishNotFoundException(dishId, restaurantId));

        if (dish.getRestaurant() != restaurant) {
            throw new DishNotFoundException(dishId, restaurantId);
        }

        if (dishDTO.getName() != null) {
            dish.setName(dishDTO.getName());
        }

        if (dishDTO.getDescription() != null) {
            dish.setDescription(dishDTO.getDescription());
        }

        if (dishDTO.getPrice() != null) {
            dish.setPrice(dishDTO.getPrice());
        }

        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void deleteDishByRestaurantIdAndDishId(long restaurantId, long dishId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                                                    .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));
        Dish dish = dishRepository.findById(dishId)
                                  .orElseThrow(() -> new DishNotFoundException(dishId, restaurantId));

        if (dish.getRestaurant() != restaurant) {
            throw new DishNotFoundException(dishId, restaurantId);
        }

        dishRepository.delete(dish);
    }
}
