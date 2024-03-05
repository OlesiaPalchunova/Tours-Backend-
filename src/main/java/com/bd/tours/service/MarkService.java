package com.bd.tours.service;

import com.bd.tours.dto.MarkDto;
import com.bd.tours.entity.Mark;
import com.bd.tours.entity.Tour;
import com.bd.tours.entity.Tourist;
import com.bd.tours.mapper.MarkMapper;
import com.bd.tours.repository.MarkRepository;
import com.bd.tours.repository.TourRepository;
import com.bd.tours.repository.TouristRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MarkService {
    private final MarkRepository markRepository;
    private final TourRepository tourRepository;
    private final TouristRepository touristRepository;
    private final MarkMapper markMapper;

    @Transactional
    public int getTouristMark(Long tourist_id, Long tour_id){
        Optional<Tour> tourOptional = tourRepository.findById(tour_id);
        Optional<Tourist> touristOptional = touristRepository.findById(tourist_id);
        if (tourOptional.isPresent() && touristOptional.isPresent()){
            Tour tour = tourOptional.get();
            Tourist tourist = touristOptional.get();
            Mark mark = markRepository.findByTourAndTourist(tour, tourist);
            if (mark != null) return mark.getMark();
        }

        return 0;
    }

    public void saveMark(MarkDto markDto) {
        markRepository.save(markMapper.mapFromDTO(markDto));
    }

    public void deleteMark(MarkDto markDto) {
        markRepository.delete(markMapper.mapFromDTO(markDto));
    }

    public Double avgMark(Long tour_id){
        return markRepository.findAverageMarkByTourId(tour_id);
    }
}
