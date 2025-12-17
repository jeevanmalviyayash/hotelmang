package com.yash.ratings.repo;

import com.yash.ratings.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {

    //Create Finder Methods
     List<Rating> findByUserId(String userId);

     List<Rating> findByHotelId(String hotelId);
}
