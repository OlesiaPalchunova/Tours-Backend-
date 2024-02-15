package com.bd.tours.repository;

import com.bd.tours.entity.Hotel;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
