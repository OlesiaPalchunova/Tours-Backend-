package com.bd.tours.repository;

import com.bd.tours.entity.Hotel;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCity(String city);
}
