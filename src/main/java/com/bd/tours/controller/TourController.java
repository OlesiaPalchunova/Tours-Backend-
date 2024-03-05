package com.bd.tours.controller;

import com.bd.tours.dto.CommentDto;
import com.bd.tours.dto.TourTimeDto;
import com.bd.tours.entity.Tour;
import com.bd.tours.service.CommentService;
import com.bd.tours.service.MarkService;
import com.bd.tours.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;
    private final CommentService commentService;
    private final MarkService markService;

    @GetMapping("/tour")
    @ResponseBody
    List<Tour> getAll() {
        return tourService.findAll();
    }

    @GetMapping("/tour/location")
    @ResponseBody
    List<Tour> getByLocation(@RequestParam String location) {
        return tourService.findByLocation(location);
    }

    @GetMapping("/tour/{id}")
    @ResponseBody
    Tour getById(@PathVariable("id") Long id) {
        return tourService.findById(id);
    }

    @GetMapping("/tour/time")
    @ResponseBody
    List<TourTimeDto> findTourTime(@RequestParam Long tour_id){
        return tourService.findTourTime(tour_id);
    }

    @GetMapping("/tour/{id}/comment")
    @ResponseBody
    List<CommentDto> findComments(@PathVariable("id") Long tour_id) {
        return commentService.findCommentsByTour(tour_id);
    }

    @GetMapping("/tour/{id}/mark")
    @ResponseBody
    Double findAvgMark(@PathVariable("id") Long tour_id) {
        return markService.avgMark(tour_id);
    }
}
