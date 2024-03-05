package com.bd.tours.mapper;

import com.bd.tours.dto.CommentDto;
import com.bd.tours.entity.Comment;
import com.bd.tours.entity.Tour;
import com.bd.tours.entity.Tourist;
import com.bd.tours.repository.CommentRepository;
import com.bd.tours.repository.TourRepository;
import com.bd.tours.repository.TouristRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class CommentMapper {
    private final CommentRepository commentRepository;
    private final TourRepository tourRepository;
    private final TouristRepository touristRepository;

    public CommentDto mapToDTO(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setContent(comment.getContent());
        dto.setId(comment.getId());
        dto.setTourId(comment.getTour().getId());
        dto.setTouristId(comment.getTourist().getId());
        dto.setDateTimeField(comment.getDateTimeField());
        return dto;
    }

    public List<CommentDto> mapListToDTO(List<Comment> comments) {
        return comments.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Comment mapFromDTO(CommentDto dto) {
        Tour tour = tourRepository.findById(dto.getTourId()).orElse(null);
        Tourist tourist = touristRepository.findById(dto.getTourId()).orElse(null);
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setTour(tour);
        comment.setId(dto.getId());
        comment.setTourist(tourist);
        comment.setDateTimeField(dto.getDateTimeField());
        return comment;
    }
}
