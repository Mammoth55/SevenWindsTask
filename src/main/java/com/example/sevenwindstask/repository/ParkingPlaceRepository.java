package com.example.sevenwindstask.repository;

import com.example.sevenwindstask.model.ParkingPlace;
import com.example.sevenwindstask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Long> {

    Optional<ParkingPlace> getByNumber(String number);
}