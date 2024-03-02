package com.bd.tours.service;

import com.bd.tours.dto.CarRentDTO;
import com.bd.tours.dto.HotelAccommodationDTO;
import com.bd.tours.dto.TourTimeDto;
import com.bd.tours.entity.*;
import com.bd.tours.mapper.CarRentMapper;
import com.bd.tours.mapper.HotelAccommodationMapper;
import com.bd.tours.mapper.TourTimeMapper;
import com.bd.tours.repository.CarRentRepository;
import com.bd.tours.repository.HotelAccommodationRepository;
import com.bd.tours.repository.TourTimeRepository;
import com.bd.tours.repository.TouristRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Tourist saveTourist(Tourist tourist){
        return touristRepository.save(tourist);
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
            tourTime.setTourists(tourists);
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
            tourTime.setTourists(tourists);
            tourTimeRepository.save(tourTime);
        }
    }


}
