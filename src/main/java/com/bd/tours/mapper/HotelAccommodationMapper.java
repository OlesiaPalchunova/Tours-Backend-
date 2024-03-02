package com.bd.tours.mapper;

import com.bd.tours.dto.HotelAccommodationDTO;
import com.bd.tours.entity.HotelAccommodation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelAccommodationMapper {

    public HotelAccommodationDTO mapToDTO(HotelAccommodation hotelAccommodation) {
        HotelAccommodationDTO dto = new HotelAccommodationDTO();
        dto.setId(hotelAccommodation.getId());
        dto.setNumber(hotelAccommodation.getNumber());
        dto.setHotelId(hotelAccommodation.getHotel().getId());
        dto.setDate(hotelAccommodation.getDate());
        dto.setPrice(hotelAccommodation.getPrice());
        dto.setCountPlaces(hotelAccommodation.getCountPlaces());
        return dto;
    }

    public List<HotelAccommodationDTO> mapListToDTO(List<HotelAccommodation> accommodations) {
        return accommodations.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

}
