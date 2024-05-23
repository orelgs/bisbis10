package com.att.tdp.bisbis10.restaurant;

import java.util.List;
import java.util.Set;

import com.att.tdp.bisbis10.dish.Dish;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private float averageRating = 0f;

    @NotNull
    private boolean isKosher;

    @NotNull
    @ElementCollection
    private Set<String> cuisines;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Dish> dishes;
}
