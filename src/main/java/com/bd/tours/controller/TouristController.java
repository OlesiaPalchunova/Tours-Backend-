package com.bd.tours.controller;

import com.bd.tours.dto.CarRentDTO;
import com.bd.tours.dto.HotelAccommodationDTO;
import com.bd.tours.entity.Tourist;
import com.bd.tours.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class TouristController {

    @Autowired
    private TouristService touristService;

    @PostMapping("/tourist")
    @ResponseBody
    Tourist save(
            @RequestBody Tourist tourist
    ) {
        return touristService.saveTourist(tourist);
    }

    @PutMapping("/tourist")
    @ResponseBody
    Tourist update(
            @RequestBody Tourist tourist
    ) {
        return touristService.saveTourist(tourist);
    }

    @GetMapping("/tourist/accommodation")
    @ResponseBody
    List<HotelAccommodationDTO> get(@RequestParam Long tourist_id){
        return touristService.findAccommodationsByTourist(tourist_id);
    }

    @PutMapping("/tourist/accommodation") // TODO
    @ResponseBody
    void updateAccommodation(@RequestBody Set<Long> tourists, @RequestParam Long acc_id){
        touristService.updateAccommodation(tourists, acc_id);
    }

//    @PutMapping("/tourist/accommodation") // TODO
//    @ResponseBody
//    void updateAccommodation1(@RequestParam Long tourist_id, @RequestParam Long acc_id){
//        touristService.updateAccommodation(tourist_id, acc_id);
//    }

    @GetMapping("/tourist/car/rent")
    @ResponseBody
    List<CarRentDTO> getCarRent(@RequestParam Long tourist_id) {
        return touristService.getCarRent(tourist_id);
    }
    @PutMapping("/tourist/car/rent/{id}")
    @ResponseBody
    void updateCarRent(@PathVariable("id") Long id, @RequestParam Long tourist_id) {
        touristService.updateCarRent(id, tourist_id);
    }
}
