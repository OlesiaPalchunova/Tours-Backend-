package com.bd.tours.repository;

import com.bd.tours.dto.TouristDTO;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {

}
