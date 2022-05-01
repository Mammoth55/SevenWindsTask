package com.sigma.task.repository;

import com.sigma.task.model.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingTicketRepository extends JpaRepository<ParkingTicket, Long> {

    Optional<ParkingTicket> getByUserCarNumber(String carNumber);

    Optional<ParkingTicket> getByParkingPlaceNumber(String parkingPlaceNumber);
}