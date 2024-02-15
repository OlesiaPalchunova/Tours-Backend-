package com.bd.tours.repository;

import com.bd.tours.entity.HotelAccommodation;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelAccommodationRepository extends JpaRepository<HotelAccommodation, Long> {
    List<HotelAccommodation> findByTourist(Tourist tourist);
    List<HotelAccommodation> findByNumber(int number);
}
