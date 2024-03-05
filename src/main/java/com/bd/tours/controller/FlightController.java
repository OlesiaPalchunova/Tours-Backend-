package com.bd.tours.controller;

import com.bd.tours.dto.TicketDto;
import com.bd.tours.entity.Flight;
import com.bd.tours.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/flight")
    @ResponseBody
    List<Flight> getAll () {
        return flightService.findAll();
    }

    @GetMapping("/flight/cities")
    @ResponseBody
    List<Flight> getAll (@RequestParam String cityArrival, @RequestParam String cityDepature) {
        return flightService.findByCites(cityArrival, cityDepature);
    }

    @GetMapping("/flight/{id}")
    @ResponseBody
    Flight getById(@PathVariable("id") Long id) {
        return flightService.findById(id);
    }

    @GetMapping("/flight/ticket")
    @ResponseBody
    List<TicketDto> getTicketsByFlight(@RequestParam Long flight_id) {
        return flightService.findTicketsByFlight(flight_id);
    }
}
