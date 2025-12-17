package com.yash.hotelservice.service;

import com.yash.hotelservice.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    // to save hotel details
    Hotel save(Hotel hotel);

    // to get hotel service by id
    Hotel getHotel(String hotelId);

    // to get all the hotel data
    List<Hotel> getAllHotel();

}
