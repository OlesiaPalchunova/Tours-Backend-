package com.bd.tours.repository;

import com.bd.tours.entity.Mark;
import com.bd.tours.entity.Tour;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    Mark findByTourAndTourist(Tour tour, Tourist tourist);

    @Query("SELECT AVG(m.mark) FROM Mark m WHERE m.tour.id = :tourId")
    Double findAverageMarkByTourId(@Param("tourId") Long tourId);
}