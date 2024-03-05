package com.bd.tours.mapper;

import com.bd.tours.dto.TouristDto;
import com.bd.tours.entity.Tourist;
import org.springframework.stereotype.Component;

@Component
public class TouristMapper {
    public TouristDto mapToDTO(Tourist tourist) {
        TouristDto dto = new TouristDto();
        dto.setId(tourist.getId());
        dto.setAge(tourist.getAge());
        dto.setLuggage(tourist.isLuggage());
        dto.setGender(tourist.getGender());
        dto.setFirstName(tourist.getFirstName());
        dto.setCountChildren(tourist.getCountChildren());
        dto.setSecondName(tourist.getSecondName());
        return dto;
    }
}
