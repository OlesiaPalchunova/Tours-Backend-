package com.bd.tours.controller;

import com.bd.tours.dto.CarRentDTO;
import com.bd.tours.entity.Car;
import com.bd.tours.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    @ResponseBody
    List<Car> getCars(){
        return carService.findAll();
    }

    @GetMapping("/car/location")
    @ResponseBody
    List<Car> getCarsByLocation(@RequestParam String location){
        return carService.findByLocation(location);
    }

    @GetMapping("/car/rent/{car_id}")
    @ResponseBody
    List<CarRentDTO> getCarRent(@PathVariable("car_id") Long car_id) {
        return carService.findRentByCar(car_id);
    }

}
