package com.bd.tours.repository;

import com.bd.tours.entity.Hotel;
import com.bd.tours.entity.HotelAccommodation;
import com.bd.tours.entity.Tourist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface HotelAccommodationRepository extends JpaRepository<HotelAccommodation, Long> {
//    List<HotelAccommodation> findByTourist(Tourist tourist);
//    List<HotelAccommodation> findByTourist(Tourist tourist);
    List<HotelAccommodation> findByNumber(int number);

    List<HotelAccommodation> findByHotel(Hotel hotel);

    List<HotelAccommodation> findByTourists(Tourist tourist);

    @Transactional
    @Modifying
    @Query("UPDATE HotelAccommodation ha SET ha.tourists = :tourists WHERE ha.id = :accommodationId")
    void setTourists(Long accommodationId, Set<Tourist> tourists);


//    @Query("""
//            SE... where acc.date > :#{#date_from.id}
//            """)
//    List<HotelAccommodation> findByDateAndNumber(Date date_from, Date date_to);
}
