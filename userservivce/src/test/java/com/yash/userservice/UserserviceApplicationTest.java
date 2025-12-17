package com.yash.userservice;

import com.yash.userservice.entities.Rating;
import com.yash.userservice.externals.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class UserserviceApplicationTest {

        @Test
        void contextLoads() {
        }

//        @Autowired
//        private RatingService service;

//       @Test
//        void createRating(){
//            Rating rating = Rating.builder().rating(10).userid("").hotelId("").feedBack("This Rating This created using feign Client Test API").build();
//            ResponseEntity<Rating> ratingObject = service.createRating(rating);
//            System.out.println("New Rating This created by Test API: "+ ratingObject.getStatusCode());
//
//        }
}
