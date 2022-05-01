package com.sigma.task.repository;

import com.sigma.task.model.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Long> {

    Optional<ParkingPlace> getByNumber(String number);
}