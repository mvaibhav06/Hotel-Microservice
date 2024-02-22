package com.project.hotel.service.services.impl;

import com.project.hotel.service.entities.Hotel;
import com.project.hotel.service.exceptions.ResourceNotFoundException;
import com.project.hotel.service.repositories.HotelRepository;
import com.project.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel createHotel(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel findById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found"));
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        hotelRepository.deleteById(id);
    }
}
