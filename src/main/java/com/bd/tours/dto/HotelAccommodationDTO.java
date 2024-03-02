package com.bd.tours.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelAccommodationDTO {

    private Long id;
    private Long hotelId;
    private LocalDate date;
    private int number;
    private int price;
    private int countPlaces;

}
