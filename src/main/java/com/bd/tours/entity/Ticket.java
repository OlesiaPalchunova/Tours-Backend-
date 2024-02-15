package com.bd.tours.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String place;

    @NonNull
    private int price;

    @NonNull
    private boolean isFree;

    @NonNull
    private String category;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
