package com.bd.tours.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tourist", schema = "tours" )
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String secondName;

    @NonNull
    private String gender;

    @Column(nullable = false, columnDefinition = "INT CHECK (age >= 0 AND age <= 100)")
    private int age;

    @NonNull
    private boolean luggage;

    @Column(nullable = false, columnDefinition = "INT CHECK (count_children >= 0)")
    private int countChildren;

    @ManyToMany(mappedBy = "tourists", fetch = FetchType.EAGER)
    private Set<TourTime> tourTimes = new HashSet<>();

    @ManyToMany(mappedBy = "tourists", fetch = FetchType.EAGER)
    private Set<HotelAccommodation> hotelAccommodations = new HashSet<>();
}
