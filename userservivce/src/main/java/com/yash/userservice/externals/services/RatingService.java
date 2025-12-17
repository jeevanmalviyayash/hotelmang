package com.yash.userservice.externals.services;

import com.yash.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient(name =  "RATING-SERVICE")
public interface RatingService {

    // post and put method

    @PostMapping("/ratings/save")
    public ResponseEntity<Rating> createRating(Rating rating);

    @PutMapping("/ratings/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/delete/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);
}
