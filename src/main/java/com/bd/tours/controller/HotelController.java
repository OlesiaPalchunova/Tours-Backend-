package com.bd.tours.controller;

import com.bd.tours.entity.Hotel;
import com.bd.tours.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel/city")
    @ResponseBody
    List<Hotel> findByCity(@RequestParam String city){
        return hotelService.findByCity(city);
    }

    @GetMapping("/hotel")
    @ResponseBody
    List<Hotel> findAll(){
        return hotelService.findAll();
    }

    @GetMapping("/hotel/{id}")
    @ResponseBody
    public Hotel findById(@PathVariable("id") Long id) {
        return hotelService.findById(id);
    }
}
