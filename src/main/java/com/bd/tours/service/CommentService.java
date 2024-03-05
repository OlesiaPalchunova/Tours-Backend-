package com.bd.tours.service;

import com.bd.tours.dto.CommentDto;
import com.bd.tours.entity.Comment;
import com.bd.tours.entity.Tour;
import com.bd.tours.mapper.CommentMapper;
import com.bd.tours.repository.CommentRepository;
import com.bd.tours.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final TourRepository tourRepository;

    public List<CommentDto> findCommentsByTour(Long tour_id) {
        Optional<Tour> tourOptional = tourRepository.findById(tour_id);
        if (tourOptional.isPresent()){
            List<Comment> comments = commentRepository.findByTour(tourOptional.get());
            return commentMapper.mapListToDTO(comments);
        }
        return new ArrayList<>();
    }

    public void saveComment(CommentDto commentDto){
        Comment comment = commentMapper.mapFromDTO(commentDto);
        commentRepository.save(comment);
    }

    public void deleteComment(CommentDto commentDto){
        Comment comment = commentMapper.mapFromDTO(commentDto);
        commentRepository.delete(comment);
    }
}
