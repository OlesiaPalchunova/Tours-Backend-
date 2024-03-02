package com.bd.tours.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "hotel_accommodation", schema = "tours" )
public class HotelAccommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private int number;

    @ManyToMany
    @JoinTable(
            name = "hotel_accommodation_tourist",
            joinColumns = @JoinColumn(name = "hotel_accommodation_id"),
            inverseJoinColumns = @JoinColumn(name = "tourist_id")
    )
    private Set<Tourist> tourists = new HashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate date;

    @NonNull
    private int price;

    @NonNull
    private int countPlaces;
}
