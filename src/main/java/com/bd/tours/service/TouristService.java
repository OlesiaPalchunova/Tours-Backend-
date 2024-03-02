package com.bd.tours.service;

import com.bd.tours.dto.CarRentDTO;
import com.bd.tours.dto.HotelAccommodationDTO;
import com.bd.tours.entity.CarRent;
import com.bd.tours.entity.HotelAccommodation;
import com.bd.tours.entity.Tourist;
import com.bd.tours.mapper.CarRentMapper;
import com.bd.tours.mapper.HotelAccommodationMapper;
import com.bd.tours.repository.CarRentRepository;
import com.bd.tours.repository.HotelAccommodationRepository;
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
}
