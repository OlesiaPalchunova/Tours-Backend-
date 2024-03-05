package com.bd.tours.service;

import com.bd.tours.dto.TicketDto;
import com.bd.tours.entity.Flight;
import com.bd.tours.entity.Ticket;
import com.bd.tours.mapper.TicketMapper;
import com.bd.tours.repository.FlightRepository;
import com.bd.tours.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public List<Flight> findByCites(String cityArrival, String cityDepature) {
        return flightRepository.findByCityArrivalAndCityDepature(cityArrival, cityDepature);
    }

    public Flight findById(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        return flightOptional.orElse(null);
    }

    public List<TicketDto> findTicketsByFlight(Long flight_id) {
        Optional<Flight> flightOptional = flightRepository.findById(flight_id);
        if (flightOptional.isPresent()) {
            List<Ticket> tickets = ticketRepository.findByFlight(flightOptional.get());
            return ticketMapper.mapListToDTO(tickets);
        }
        return new ArrayList<>();
    }
}
