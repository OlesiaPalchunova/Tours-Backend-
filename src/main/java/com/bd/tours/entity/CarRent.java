package com.bd.tours.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "car_rent")
public class CarRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeField;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;
}
