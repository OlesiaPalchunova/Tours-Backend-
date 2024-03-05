package com.bd.tours.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.bd.tours.entity.Ticket}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketDto implements Serializable {
    Long id;
    int price;
    String category;
    String place;
    Long flightId;
    Long touristId;
}