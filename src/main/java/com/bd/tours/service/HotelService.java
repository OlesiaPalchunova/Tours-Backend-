package com.bd.tours.service;


import com.bd.tours.entity.Hotel;
import com.bd.tours.repository.HotelAccommodationRepository;
import com.bd.tours.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findByCity(String city) {
        return hotelRepository.findByCity(city);
    }
}
