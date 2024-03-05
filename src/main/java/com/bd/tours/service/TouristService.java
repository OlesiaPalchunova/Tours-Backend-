package com.bd.tours.service;

import com.bd.tours.dto.*;
import com.bd.tours.entity.*;
import com.bd.tours.mapper.*;
import com.bd.tours.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TouristService {

    private final TouristRepository touristRepository;
    private final HotelAccommodationRepository hotelAccommodationRepository;
    private final HotelAccommodationMapper hotelAccommodationMapper;
    private final CarRentRepository carRentRepository;
    private final CarRentMapper carRentMapper;
    private final TourTimeRepository tourTimeRepository;
    private final TourTimeMapper tourTimeMapper;
    private final TouristMapper touristMapper;
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public Tourist saveTourist(Tourist tourist){
        return touristRepository.save(tourist);
    }

    public TouristDto findById(Long id) {
        Optional<Tourist> touristOptional = touristRepository.findById(id);
        if (touristOptional.isPresent()) {
            return touristMapper.mapToDTO(touristOptional.get());
        }
        return null;
    }


    public List<HotelAccommodationDTO> findAccommodationsByTourist(Long touristId) {
        Optional<Tourist> optionalTourist = touristRepository.findById(touristId);
        if (optionalTourist.isPresent()) {
            Tourist tourist = optionalTourist.get();
            List<HotelAccommodation> acc = hotelAccommodationRepository.findByTourists(tourist);
            return hotelAccommodationMapper.mapListToDTO(acc);
        } else {
            return new ArrayList<>();
        }
    }

    public void updateAccommodation(Set<Long> touristIds, Long accommodationId) {
        Optional<HotelAccommodation> optionalAccommodation = hotelAccommodationRepository.findById(accommodationId);
        if (optionalAccommodation.isPresent()) {
            HotelAccommodation accommodation = optionalAccommodation.get();

            Set<Tourist> tourists = new HashSet<>();
            for (Long touristId : touristIds) {
                Optional<Tourist> optionalTourist = touristRepository.findById(touristId);
                optionalTourist.ifPresent(tourists::add);
            }

            accommodation.setTourists(tourists);
            hotelAccommodationRepository.save(accommodation);
        }
    }

    public void updateCarRent(Long id, Long tourist_id) {
        Optional<CarRent> carRentOptional = carRentRepository.findById(id);
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        if (carRentOptional.isPresent() && touristOptional.isPresent()) {
            CarRent carRent = carRentOptional.get();
            Tourist tourist = touristOptional.get();
            carRent.setTourist(tourist);
            carRentRepository.save(carRent);
        }
    }

    public List<CarRentDTO> getCarRent(Long tourist_id) {
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        if (touristOptional.isPresent()) {
            List<CarRent> carRents = carRentRepository.findByTourist(touristOptional.get());
            return carRentMapper.mapListToDTO(carRents);
        }
        return new ArrayList<>();
    }

    public List<TourTimeDto> getTourTime(Long tourist_id) {
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        if (touristOptional.isPresent()) {
            List<TourTime> tourTimes = tourTimeRepository.findByTourists(touristOptional.get());
            return tourTimeMapper.mapListToDTO(tourTimes);
        }
        return new ArrayList<>();
    }

    public void putTourTime(Long tour_time_id, Long tourist_id) {
        Optional<TourTime> tourTimeOptional = tourTimeRepository.findById(tour_time_id);
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        if (tourTimeOptional.isPresent() && touristOptional.isPresent()){
            TourTime tourTime = tourTimeOptional.get();
            Tourist tourist = touristOptional.get();
            Set<Tourist> tourists = tourTime.getTourists();
            tourists.add(tourist);
            tourTimeRepository.save(tourTime);
        }
    }

    public void deleteTourTime(Long tour_time_id, Long tourist_id) {
        Optional<TourTime> tourTimeOptional = tourTimeRepository.findById(tour_time_id);
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        if (tourTimeOptional.isPresent() && touristOptional.isPresent()){
            TourTime tourTime = tourTimeOptional.get();
            Tourist tourist = touristOptional.get();
            Set<Tourist> tourists = tourTime.getTourists();
            tourists.remove(tourist);
            tourTimeRepository.save(tourTime);
        }
    }


    @Transactional
    public void deleteCarRent(Long tour_time_id) {
        Optional<CarRent> carRentOptional = carRentRepository.findById(tour_time_id);
        if (carRentOptional.isPresent()) {
            CarRent carRent = carRentOptional.get();
            carRent.setTourist(null);
            carRentRepository.save(carRent);
        }
    }

    @Transactional
    public List<TicketDto> findTicketsByTourist(Long tourist_id) {
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        if (touristOptional.isPresent()){
            List<Ticket> tickets = ticketRepository.findByTourist(touristOptional.get());
            return ticketMapper.mapListToDTO(tickets);
        }
        return new ArrayList<>();
    }

    @Transactional
    public void updateTicket(Long tourist_id, Long ticket_id) {
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticket_id);
        if (touristOptional.isPresent() && ticketOptional.isPresent()){
            Tourist tourist = touristOptional.get();
            Ticket ticket = ticketOptional.get();
            ticket.setTourist(tourist);
            ticketRepository.save(ticket);
        }
    }

    @Transactional
    public void deleteTicket(Long ticket_id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticket_id);
        if (ticketOptional.isPresent()){
            Ticket ticket = ticketOptional.get();
            ticket.setTourist(null);
            ticketRepository.save(ticket);
        }
    }
}
