package com.bd.tours.service;

import com.bd.tours.dto.HotelAccommodationDTO;
import com.bd.tours.entity.Hotel;
import com.bd.tours.entity.HotelAccommodation;
import com.bd.tours.repository.HotelAccommodationRepository;
import com.bd.tours.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelAccommodationService {
    @Autowired
    private HotelAccommodationRepository accommodationRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelAccommodationDTO> findByHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            return new ArrayList<>();
        }
        List<HotelAccommodation> accommodations = accommodationRepository.findByHotel(hotel);
        return accommodations.stream()
                .map(this::mapToDTO) // Преобразование сущности в DTO
                .collect(Collectors.toList());
    }

    private HotelAccommodationDTO mapToDTO(HotelAccommodation accommodation) {
        return new HotelAccommodationDTO(
                accommodation.getId(),
                accommodation.getHotel().getId(),
                accommodation.getDate(),
                accommodation.getNumber(),
                accommodation.getPrice(),
                accommodation.getCountPlaces()
        );
    }
}
