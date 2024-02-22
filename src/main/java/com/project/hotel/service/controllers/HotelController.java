package com.project.hotel.service.controllers;

import com.project.hotel.service.entities.Hotel;
import com.project.hotel.service.services.HotelService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        Hotel dbHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(dbHotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll(){
        List<Hotel> hotels = hotelService.findAll();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable String id){
        Hotel hotel = hotelService.findById(id);
        return ResponseEntity.ok(hotel);
    }
}
