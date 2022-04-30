package com.example.sevenwindstask.repository;

import com.example.sevenwindstask.model.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingTicketRepository extends JpaRepository<ParkingTicket, Long> {

    Optional<ParkingTicket> getByUserCarNumber(String carNumber);

    Optional<ParkingTicket> getByParkingPlaceNumber(String parkingPlaceNumber);
}