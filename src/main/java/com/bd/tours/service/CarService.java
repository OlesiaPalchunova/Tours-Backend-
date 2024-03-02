package com.bd.tours.service;

import com.bd.tours.dto.CarRentDTO;
import com.bd.tours.entity.Car;
import com.bd.tours.entity.CarRent;
import com.bd.tours.mapper.CarRentMapper;
import com.bd.tours.repository.CarRentRepository;
import com.bd.tours.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarRentRepository carRentRepository;
    private final CarRentMapper carRentMapper;

    public List<Car> findAll() {
        return carRepository.findAll();
    }
    public List<Car> findByLocation(String location) {
        return carRepository.findByLocation(location);
    }

    public List<CarRentDTO> findRentByCar(Long car_id) {
        Optional<Car> carOptional = carRepository.findById(car_id);
        if (carOptional.isPresent()){
            System.out.println(99999);
            List<CarRent> rents = carRentRepository.findByCar(carOptional.get());
            return carRentMapper.mapListToDTO(rents);
        }
        return new ArrayList<>();
    }


}
