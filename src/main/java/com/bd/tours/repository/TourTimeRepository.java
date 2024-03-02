package com.bd.tours.repository;

import com.bd.tours.entity.Tour;
import com.bd.tours.entity.TourTime;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourTimeRepository extends JpaRepository<TourTime, Long> {
    List<TourTime> findByTour (Tour tour);

//    List<TourTime> findByTourist(Tourist tourist);

    List<TourTime> findByTourists(Tourist tourist);
}