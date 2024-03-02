package com.bd.tours.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRentDTO {
    private Long id;
    private Date dateTimeField;
    private Long car_id;
    private Long tourist_id;

}
