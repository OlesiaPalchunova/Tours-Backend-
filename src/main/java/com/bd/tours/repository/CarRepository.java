package com.bd.tours.repository;

import com.bd.tours.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository  extends JpaRepository<Car, Long> {
    List<Car> findAll();
    List<Car> findByLocation(String location);
}
