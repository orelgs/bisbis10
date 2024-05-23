package com.att.tdp.bisbis10.restaurant;

import java.util.Set;

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
}
