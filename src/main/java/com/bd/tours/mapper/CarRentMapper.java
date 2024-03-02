package com.bd.tours.mapper;

import com.bd.tours.dto.CarRentDTO;
import com.bd.tours.entity.CarRent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarRentMapper {
    public CarRentDTO mapToDTO(CarRent carRent) {
        CarRentDTO dto = new CarRentDTO();
        dto.setId(carRent.getId());
        dto.setCar_id(carRent.getCar().getId());
        dto.setDateTimeField(carRent.getDateTimeField());
        dto.setTourist_id(carRent.getTourist().getId());
        return dto;
    }

    public List<CarRentDTO> mapListToDTO(List<CarRent> carRents) {
        return carRents.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
