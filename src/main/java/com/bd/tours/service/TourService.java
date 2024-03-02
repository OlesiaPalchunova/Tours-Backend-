package com.bd.tours.service;

import com.bd.tours.dto.TourTimeDto;
import com.bd.tours.entity.Tour;
import com.bd.tours.entity.TourTime;
import com.bd.tours.mapper.TourTimeMapper;
import com.bd.tours.repository.TourRepository;
import com.bd.tours.repository.TourTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;
    private final TourTimeRepository tourTimeRepository;
    private final TourTimeMapper tourTimeMapper;

    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    public List<Tour> findByLocation(String location) {
        return tourRepository.findByLocation(location);
    }

    public Tour findById(Long id) {
        return tourRepository.findById(id).get();
    }

    public List<TourTimeDto> findTourTime(Long tour_id) {
        Optional<Tour> tourOptional = tourRepository.findById(tour_id);
        if (tourOptional.isPresent()){
            List<TourTime> tourTime = tourTimeRepository.findByTour(tourOptional.get());
            return tourTimeMapper.mapListToDTO(tourTime);
        }
        return new ArrayList<>();
    }


}
