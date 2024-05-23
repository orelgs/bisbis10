package com.att.tdp.bisbis10.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.exception.RestaurantNotFoundException;
import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.att.tdp.bisbis10.restaurant.RestaurantRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    @Transactional
    public void addRating(@Valid RatingDTO ratingDTO) {
        Restaurant restaurant = restaurantRepository.findById(ratingDTO.getRestaurantId())
                                                    .orElseThrow(() -> new RestaurantNotFoundException(ratingDTO.getRestaurantId()));
        Rating rating = new Rating();

        rating.setRestaurant(restaurant);
        rating.setRating(ratingDTO.getRating());
        ratingRepository.save(rating);
        restaurant.updateAverageRating();
    }
}
