package com.yash.userservice.services.serviceImpl;

import com.yash.userservice.Exception.ResourceNotFound;
import com.yash.userservice.entities.Hotel;
import com.yash.userservice.entities.Rating;
import com.yash.userservice.entities.User;
import com.yash.userservice.externals.services.HotelService;
import com.yash.userservice.repositories.UserRepository;
import com.yash.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        // unique user id will be generated
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return repository.save(user);
    }

    @Override
    public List<User> getAlluser() {
        return repository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //getting user with the help of user repository
        User user = repository.findById(userId).orElseThrow(()-> new ResourceNotFound("User With Given Id is not present! "+ userId));

        // fetch rating of the above-fetched user from rating service
        //http://localhost:8082/ratings/users/01f188c5-08b1-474f-9beb-8e3c4d5aea78

        Rating[] ratingsOfUser =restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        log.info("{}",ratingsOfUser);

        List<Rating> ratings =Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingsList =ratings.stream()
                        .map(rat -> {
                            //api call to hotel to get the hotel
                            //hotel service url http://localhost:8081/hotel/ec3d8555-be66-454f-b2a9-5cf32b1acfbb
                            //ResponseEntity<Hotel> hotelEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rat.getHotelId(), Hotel.class);

                            Hotel hotel =hotelService.getHotel(rat.getHotelId());

                           // log.info("ResponseEntity status code:{}", hotelEntity.getStatusCode());
                            //set the hotel to rating
                            rat.setHotel(hotel);
                            // return the rating
                            return rat;
                        }).collect(Collectors.toList());

        user.setRatings(ratingsList);


        return user;
    }
}
