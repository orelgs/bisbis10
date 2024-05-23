package com.att.tdp.bisbis10.rating;

import jakarta.validation.Valid;

public interface RatingService {
    void addRating(@Valid RatingDTO ratingDTO);
}
