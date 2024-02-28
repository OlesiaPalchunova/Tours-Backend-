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

    @ManyToMany
    @JoinTable(
            name = "car_rent_tourist",
            joinColumns = @JoinColumn(name = "car_rent_tourist"),
            inverseJoinColumns = @JoinColumn(name = "tourist_id")
    )
    private Set<Tourist> tourists = new HashSet<>();
}
