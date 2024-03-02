package com.bd.tours.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelDTO {

    private Long id;
    private String name;
    private String city;
    private int countRooms;

}
