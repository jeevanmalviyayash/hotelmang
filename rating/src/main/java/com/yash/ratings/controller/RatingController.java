package com.yash.ratings.controller;

import com.yash.ratings.entities.Rating;
import com.yash.ratings.service.RatingService;
import jakarta.ws.rs.DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private static final ThreadLocal<String> context = new ThreadLocal<>();

    @Autowired
    private RatingService service;

    @PostMapping("/save")
    public ResponseEntity<Rating> saveRatings(@RequestBody Rating req){
        Rating rating = service.save(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

    @GetMapping("{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
        return ResponseEntity.ok(service.getRating(ratingId));
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Rating>> getAllRatings(){

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(service.getRatingByUserId(userId));
    }

    @GetMapping("hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
    }

    @PutMapping("/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating){
        return ResponseEntity.ok(service.updateRating(ratingId, rating));
    }

    @DeleteMapping("/delete/{ratingId}")
    public ResponseEntity<?> deleteRating(@PathVariable("ratingId")String ratingId){
        //return ResponseEntity.ok(service.deleteRating(ratingId));
        return ResponseEntity.ok().build();  // Return HTTP 200 OK without body
    }
}
