package com.yash.ratings.service;

import com.yash.ratings.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    Rating save(Rating req);

    Rating getRating(String id);

    List<Rating> getAll();

    List<Rating> getRatingByUserId(String id);

    List<Rating> getRatingByHotelId(String id);

    Rating updateRating(String ratingId, Rating rating);

    void deleteRating(String ratingId);

}
