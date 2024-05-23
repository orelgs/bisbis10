package com.att.tdp.bisbis10.dish;

import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Restaurant restaurant;

    private String name;

    private String description;

    private float price;

    public Long getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static Dish createDishFromDTO(DishDTO dishDTO) {
        Dish dish = new Dish();

        dish.setName(dishDTO.getName());
        dish.setDescription(dishDTO.getDescription());
        dish.setPrice(dishDTO.getPrice());

        return dish;
    }
}
