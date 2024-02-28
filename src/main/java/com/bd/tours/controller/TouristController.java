package com.bd.tours.controller;

import com.bd.tours.dto.TouristDTO;
import com.bd.tours.entity.Tour;
import com.bd.tours.entity.Tourist;
import com.bd.tours.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
