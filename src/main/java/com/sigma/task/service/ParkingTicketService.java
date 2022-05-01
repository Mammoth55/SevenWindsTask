package com.sigma.task.service;

import com.sigma.task.dto.request.ParkingTicketDtoRequest;
import com.sigma.task.exeptionhandling.EntityNotFoundException;
import com.sigma.task.model.ParkingPlace;
import com.sigma.task.model.ParkingTicket;
import com.sigma.task.model.User;
import com.sigma.task.repository.ParkingPlaceRepository;
import com.sigma.task.repository.ParkingTicketRepository;
import com.sigma.task.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ParkingTicketService {

    private static final String DATE_TIME_PATTERN = "yyyy/MM/dd hh:mm";
    private static final ZoneId TARGET_ZONE_ID = ZoneId.of("America/Toronto");

    private final ParkingTicketRepository parkingTicketRepository;
    private final ParkingPlaceRepository parkingPlaceRepository;
    private final UserRepository userRepository;

    public ParkingTicketService(ParkingTicketRepository parkingTicketRepository,
                                ParkingPlaceRepository parkingPlaceRepository,
                                UserRepository userRepository) {
        this.parkingTicketRepository = parkingTicketRepository;
        this.parkingPlaceRepository = parkingPlaceRepository;
        this.userRepository = userRepository;
    }

    public List<ParkingTicket> getAll() {
        return parkingTicketRepository.findAll();
    }

    public ParkingTicket getById(long id) {
        return parkingTicketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingTicket with ID = "
                        + id + " in Database."));
    }

    public ParkingTicket getByUserCarNumber(String carNumber) {
        return parkingTicketRepository.getByUserCarNumber(carNumber)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingTicket with carNumber = "
                        + carNumber + " in Database."));
    }

    public ParkingTicket getByParkingPlaceNumber(String parkingPlaceNumber) {
        return parkingTicketRepository.getByParkingPlaceNumber(parkingPlaceNumber)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingTicket with parkingPlaceNumber = "
                        + parkingPlaceNumber + " in Database."));
    }

    @Transactional
    public ParkingTicket create(long id, ParkingTicketDtoRequest request) {
        String placeNumber = request.getParkingPlaceNumber();
        ParkingPlace parkingPlace = parkingPlaceRepository.getByNumber(placeNumber)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingPlace with parkingPlaceNumber = "
                        + placeNumber + " in Database."));
        String userCarNumber = request.getUserCarNumber();
        User user = userRepository.getByCarNumber(userCarNumber)
                .orElseThrow(() -> new EntityNotFoundException("There is no User with userCarNumber = "
                        + userCarNumber + " in Database."));
        Instant time = LocalDateTime.parse(
                        request.getStartTime(),
                        DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))
                .atZone(TARGET_ZONE_ID)
                .toInstant();
        return parkingTicketRepository.save(ParkingTicket.builder()
                .id(id)
                .parkingPlace(parkingPlace)
                .user(user)
                .startTime(time)
                .durationInMinutes(request.getDurationInMinutes())
                .prepaid(request.isPrepaid())
                .build());
    }

    @Transactional
    public ParkingTicket update(long id, ParkingTicketDtoRequest request) {
        var parkingTicket = parkingTicketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingTicket with ID = " + id + " in Database."));
        create(id, request);
        return parkingTicket;
    }

    @Transactional
    public ParkingTicket deleteById(long id) {
        var parkingTicket = parkingTicketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingTicket with ID = " + id + " in Database."));
        parkingTicketRepository.deleteById(id);
        return parkingTicket;
    }
}