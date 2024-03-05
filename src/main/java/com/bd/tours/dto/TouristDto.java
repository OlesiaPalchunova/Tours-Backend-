package com.bd.tours.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.bd.tours.entity.Tourist}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TouristDto implements Serializable {
    Long id;
    String firstName;
    String secondName;
    String gender;
    int age;
    boolean luggage;
    int countChildren;
}