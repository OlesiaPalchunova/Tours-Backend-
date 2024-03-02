package com.bd.tours.service;


import com.bd.tours.entity.Hotel;
import com.bd.tours.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findByCity(String city) {
        return hotelRepository.findByCity(city);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
    public Hotel findById(Long id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        return optionalHotel.orElse(null);
    }
}
