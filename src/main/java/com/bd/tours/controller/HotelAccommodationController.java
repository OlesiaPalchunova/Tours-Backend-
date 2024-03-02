package com.bd.tours.controller;

import com.bd.tours.dto.HotelAccommodationDTO;
import com.bd.tours.service.HotelAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HotelAccommodationController {
    @Autowired
    private HotelAccommodationService accommodationService;

    @GetMapping("/hotel/accommodation/{hotel_id}")
    @ResponseBody
    List<HotelAccommodationDTO> get(@PathVariable("hotel_id") Long hotel_id){
        return accommodationService.findByHotel(hotel_id);
    }
}
