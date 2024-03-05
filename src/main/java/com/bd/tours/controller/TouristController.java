package com.bd.tours.controller;

import com.bd.tours.dto.*;
import com.bd.tours.entity.Tourist;
import com.bd.tours.service.CommentService;
import com.bd.tours.service.MarkService;
import com.bd.tours.service.TouristService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class TouristController {

    private final TouristService touristService;
    private final CommentService commentService;
    private final MarkService markService;

    @PostMapping("/tourist")
    @ResponseBody
    Tourist save(
            @RequestBody Tourist tourist
    ) {
        return touristService.saveTourist(tourist);
    }

    @PutMapping("/tourist")
    @ResponseBody
    Tourist update(
            @RequestBody Tourist tourist
    ) {
        return touristService.saveTourist(tourist);
    }

    @GetMapping("/tourist/{id}")
    @ResponseBody
    TouristDto getTourist(@PathVariable("id") Long id ) {
        return touristService.findById(id);
    }


    @GetMapping("/tourist/accommodation")
    @ResponseBody
    List<HotelAccommodationDTO> getAccommodations(@RequestParam Long tourist_id){
        return touristService.findAccommodationsByTourist(tourist_id);
    }

    @PutMapping("/tourist/accommodation") // TODO
    @ResponseBody
    void updateAccommodation(@RequestBody Set<Long> tourists, @RequestParam Long acc_id){
        touristService.updateAccommodation(tourists, acc_id);
    }

//    @PutMapping("/tourist/accommodation") // TODO
//    @ResponseBody
//    void updateAccommodation1(@RequestParam Long tourist_id, @RequestParam Long acc_id){
//        touristService.updateAccommodation(tourist_id, acc_id);
//    }

    @GetMapping("/tourist/car/rent")
    @ResponseBody
    List<CarRentDTO> getCarRent(@RequestParam Long tourist_id) {
        return touristService.getCarRent(tourist_id);
    }

    @PutMapping("/tourist/car/rent/{id}")
    @ResponseBody
    void updateCarRent(@PathVariable("id") Long id, @RequestParam Long tourist_id) {
        touristService.updateCarRent(id, tourist_id);
    }

    @DeleteMapping("/tourist/car/rent/{id}")
    @ResponseBody
    ResponseEntity<Void> deleteCarRent(@PathVariable("id") Long id) {
        touristService.deleteCarRent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tourist/tour/time/{id}")
    @ResponseBody
    List<TourTimeDto> getTourTimes(@PathVariable("id") Long tourist_id) {
        return touristService.getTourTime(tourist_id);
    }


    @PutMapping("/tourist/tour/time/{id}")
    @ResponseBody
    void getTourTimes(@RequestParam Long tourist_id, @PathVariable("id") Long tour_time_id) {
        touristService.putTourTime(tour_time_id, tourist_id);
    }

    @DeleteMapping("/tourist/tour/time/{id}")
    @ResponseBody
    void deleteTourTimes(@RequestParam Long tourist_id, @PathVariable("id") Long tour_time_id) {
        touristService.deleteTourTime(tour_time_id, tourist_id);
    }

    @GetMapping("/tourist/ticket/{id}")
    @ResponseBody
    List<TicketDto> findTicketsByTourist(@PathVariable("id") Long id) {
        return touristService.findTicketsByTourist(id);
    }

    @PutMapping("/tourist/ticket/{ticket_id}")
    @ResponseBody
    void putTicket(@PathVariable("ticket_id") Long ticket_id, @RequestParam Long tourist_id) {
        touristService.updateTicket(tourist_id, ticket_id);
    }

    @DeleteMapping("/tourist/ticket/{ticket_id}")
    @ResponseBody
    void deleteTicket(@PathVariable("ticket_id") Long ticket_id) {
        touristService.deleteTicket(ticket_id);
    }

    @PostMapping("/tourist/tour/comment")
    @ResponseBody
    void postComment(@RequestBody CommentDto commentDto){
        commentService.saveComment(commentDto);
    }

    @PutMapping("/tourist/tour/comment")
    @ResponseBody
    void putComment(@RequestBody CommentDto commentDto){
        commentService.saveComment(commentDto);
    }

    @DeleteMapping("/tourist/tour/comment")
    @ResponseBody
    void deleteComment(@RequestBody CommentDto commentDto){
        commentService.deleteComment(commentDto);
    }

    @GetMapping("tourist/tour/mark")
    @ResponseBody
    int getMark(@RequestParam Long tourist_id, @RequestParam Long tour_id){
        return markService.getTouristMark(tourist_id, tour_id);
    }

    @PostMapping("/tourist/tour/mark")
    @ResponseBody
    void saveMark(@RequestBody MarkDto markDto){
        markService.saveMark(markDto);
    }

    @PutMapping("/tourist/tour/mark")
    @ResponseBody
    void putMark(@RequestBody MarkDto markDto){
        markService.saveMark(markDto);
    }

    @DeleteMapping("/tourist/tour/mark")
    @ResponseBody
    void deleteMark(@RequestBody MarkDto markDto){
        markService.deleteMark(markDto);
    }
}
