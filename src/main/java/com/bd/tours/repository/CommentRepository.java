package com.bd.tours.repository;

import com.bd.tours.entity.Comment;
import com.bd.tours.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

     List<Comment> findByTour(Tour tour);
}