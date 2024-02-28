package com.bd.tours.service;

import com.bd.tours.dto.TouristDTO;
import com.bd.tours.entity.Tourist;
import com.bd.tours.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;
    public Tourist saveTourist(Tourist tourist){
        return touristRepository.save(tourist);
    }
}
