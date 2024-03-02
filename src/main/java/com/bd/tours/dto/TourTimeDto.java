package com.bd.tours.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * DTO for {@link com.bd.tours.entity.TourTime}
 */
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
public class TourTimeDto implements Serializable {
    Long id;
    Long tourId;
    Set<Long> touristIds;
    Date dateTimeField;
    int price;
}