package com.bd.tours.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tour_time", schema = "tours" )
public class TourTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToMany
    @JoinTable(
            name = "tour_time_tourist",
            joinColumns = @JoinColumn(name = "tour_time_id"),
            inverseJoinColumns = @JoinColumn(name = "tourist_id")
    )
    private Set<Tourist> tourists = new HashSet<>();

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeField;

    @NonNull
    private int price;
}
