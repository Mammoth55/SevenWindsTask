package com.example.sevenwindstask.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", columnDefinition = "varchar(255) not null")
    private String firstName;

    @Column(name = "middle_name", columnDefinition = "varchar(255)")
    private String middleName;

    @Column(name = "last_name", columnDefinition = "varchar(255)")
    private String lastName;

    @Column(name = "email", columnDefinition = "varchar(255) not null")
    private String email;

    @Column(name = "phone_number", columnDefinition = "varchar(16) not null")
    private String phoneNumber;

    @Column(name = "car_number", columnDefinition = "varchar(16) not null unique")
    private String carNumber;

    @Column(name = "car_model", columnDefinition = "varchar(255) not null")
    private String carModel;
}