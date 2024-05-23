package com.att.tdp.bisbis10.restaurant;

import java.util.List;
import java.util.Set;

import com.att.tdp.bisbis10.dish.Dish;
import com.att.tdp.bisbis10.rating.Rating;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float averageRating = 0f;

    private boolean isKosher;

    @ElementCollection
    private Set<String> cuisines;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Dish> dishes;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Rating> ratings;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void updateAverageRating() {
        if (ratings.isEmpty()) {
            averageRating = 0;
        } else {
            float sum = 0;

            for (Rating rating : ratings) {
                sum += rating.getRating();
            }

            averageRating = sum / ratings.size();
        }
    }

    public boolean getIsKosher() {
        return isKosher;
    }

    public void setKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public static Restaurant createRestaurantFromDTO(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();

        restaurant.setName(restaurantDTO.getName());
        restaurant.setKosher(restaurantDTO.isKosher());
        restaurant.setCuisines(restaurantDTO.getCuisines());

        return restaurant;
    }
}
