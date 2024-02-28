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
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeField;

    @NonNull
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;
}
