package com.bd.tours.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.bd.tours.entity.Flight}
 */
@Value
public class FlightDto implements Serializable {
    Long id;
}