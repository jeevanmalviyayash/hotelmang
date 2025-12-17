package com.yash.hotelservice.Controller;

import com.yash.hotelservice.entities.Hotel;
import com.yash.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = service.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }


    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(service.getHotel(hotelId));
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(service.getAllHotel());
    }
}
