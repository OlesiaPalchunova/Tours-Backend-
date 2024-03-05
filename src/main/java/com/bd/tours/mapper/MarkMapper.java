package com.bd.tours.mapper;

import com.bd.tours.dto.MarkDto;
import com.bd.tours.entity.Mark;
import com.bd.tours.entity.Tour;
import com.bd.tours.entity.Tourist;
import com.bd.tours.repository.MarkRepository;
import com.bd.tours.repository.TourRepository;
import com.bd.tours.repository.TouristRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MarkMapper {

    private final MarkRepository markRepository;
    private final TourRepository tourRepository;
    private final TouristRepository touristRepository;

    public MarkDto mapToDTO(Mark mark) {
        MarkDto dto = new MarkDto();
        dto.setId(mark.getId());
        dto.setMark(mark.getMark());
        dto.setTourId(mark.getTour().getId());
        dto.setTouristId(mark.getTourist().getId());
        return dto;
    }

    public List<MarkDto> mapListToDTO(List<Mark> marks) {
        return marks.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Mark mapFromDTO(MarkDto dto) {
        Tour tour = tourRepository.findById(dto.getTourId()).orElse(null);
        Tourist tourist = touristRepository.findById(dto.getTouristId()).orElse(null);
        Mark mark = new Mark();
        mark.setMark(dto.getMark());
        mark.setTour(tour);
        mark.setId(dto.getId());
        mark.setTourist(tourist);
        return mark;
    }
}
