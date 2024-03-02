package com.bd.tours.repository;

import com.bd.tours.entity.Car;
import com.bd.tours.entity.CarRent;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRentRepository extends JpaRepository<CarRent, Long> {
    List<CarRent> findByCar(Car car);

    List<CarRent> findByTourist(Tourist tourist);

}
