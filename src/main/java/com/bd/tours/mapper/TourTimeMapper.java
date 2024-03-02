package com.bd.tours.mapper;

import com.bd.tours.dto.TourTimeDto;
import com.bd.tours.entity.TourTime;
import com.bd.tours.entity.Tourist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TourTimeMapper {

    Set<Long> touristSetToTouristIds(Set<Tourist> tourists) {
        return tourists.stream()
                .map(Tourist::getId)
                .collect(Collectors.toSet());
    }

    public TourTimeDto mapToDTO(TourTime tourTime) {
        TourTimeDto dto = new TourTimeDto();
        dto.setId(tourTime.getId());
        dto.setPrice(tourTime.getPrice());
        dto.setDateTimeField(tourTime.getDateTimeField());
        dto.setTouristIds(touristSetToTouristIds(tourTime.getTourists()));
        dto.setTourId(tourTime.getTour().getId());
        return dto;
    }

    public List<TourTimeDto> mapListToDTO(List<TourTime> tourTimes) {
        return tourTimes.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
