package com.bd.tours.repository;

import com.bd.tours.entity.Hotel;
import com.bd.tours.entity.HotelAccommodation;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HotelAccommodationRepository extends JpaRepository<HotelAccommodation, Long> {
    List<HotelAccommodation> findByTourist(Tourist tourist);
    List<HotelAccommodation> findByNumber(int number);

    List<HotelAccommodation> findByHotel(Hotel hotel);

//    @Query("""
//            SE... where acc.date > :#{#date_from.id}
//            """)
//    List<HotelAccommodation> findByDateAndNumber(Date date_from, Date date_to);
}
