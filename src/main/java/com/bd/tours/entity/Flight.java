package com.bd.tours.entity;

import jakarta.persistence.*;
import jdk.jfr.Timespan;
import lombok.*;
import org.springframework.lang.NonNull;

import java.sql.Time;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String cityDepature;

    @NonNull
    private String cityArrival;

    @Temporal(TemporalType.TIME)
    private Time timeDepature;

    @Temporal(TemporalType.TIME)
    private Time timeArrival;

    @NonNull
    private String company;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
}
