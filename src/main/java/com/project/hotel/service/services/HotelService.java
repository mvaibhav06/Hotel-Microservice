package com.project.hotel.service.services;

import com.project.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel findById(String id);
    List<Hotel> findAll();
    void deleteById(String id);
}
