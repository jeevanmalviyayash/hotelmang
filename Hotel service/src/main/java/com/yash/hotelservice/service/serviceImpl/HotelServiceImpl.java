package com.yash.hotelservice.service.serviceImpl;

import com.yash.hotelservice.Exception.ResourceNotFound;
import com.yash.hotelservice.entities.Hotel;
import com.yash.hotelservice.repository.HotelRepo;
import com.yash.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo repo;

    @Override
    public Hotel save(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setHotelId(randomHotelId);
        return repo.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return repo.findById(hotelId).orElseThrow(()-> new ResourceNotFound("Hotel with this Given setHotelId is annotation present: "+ hotelId));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return repo.findAll();
    }
}
