package com.example.sevenwindstask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "parking_places")
public class ParkingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number", columnDefinition = "varchar(8) not null unique")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "varchar(16) not null")
    private ParkingPlaceStatus status;

    @Column(name = "price", columnDefinition = "float not null")
    private double price;
}