package com.bd.tours.repository;

import com.bd.tours.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByCityArrivalAndCityDepature(String cityArrival, String cityDepature);
}