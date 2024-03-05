package com.bd.tours.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.bd.tours.entity.Mark}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MarkDto implements Serializable {
    Long id;
    int mark;
    Long tourId;
    Long touristId;
}