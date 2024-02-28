package com.bd.tours.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String brand;

    @NonNull
    private String category;

    @NonNull
    private int price;

    @NonNull
    private int countPlace;

    @NonNull
    private String location;
}
