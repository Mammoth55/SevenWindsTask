package com.example.sevenwindstask.service;

import com.example.sevenwindstask.dto.request.ParkingPlaceDtoRequest;
import com.example.sevenwindstask.exeptionhandling.EntityNotFoundException;
import com.example.sevenwindstask.model.ParkingPlace;
import com.example.sevenwindstask.model.ParkingPlaceStatus;
import com.example.sevenwindstask.repository.ParkingPlaceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParkingPlaceService {

    private final ParkingPlaceRepository parkingPlaceRepository;

    public ParkingPlaceService(ParkingPlaceRepository parkingPlaceRepository) {
        this.parkingPlaceRepository = parkingPlaceRepository;
    }

    public List<ParkingPlace> getAll() {
        return parkingPlaceRepository.findAll();
    }

    public ParkingPlace getById(long id) {
        return parkingPlaceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingPlace with ID = " + id + " in Database."));
    }

    public ParkingPlace getByNumber(String number) {
        return parkingPlaceRepository.getByNumber(number)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingPlace with Number = " + number + " in Database."));
    }

    @Transactional
    public ParkingPlace create(long id, ParkingPlaceDtoRequest request) {
        return parkingPlaceRepository.save(ParkingPlace.builder()
                .id(id)
                .number(request.getNumber())
                .status(ParkingPlaceStatus.valueOf(request.getStatus()))
                .price(request.getPrice())
                .build());
    }

    @Transactional
    public ParkingPlace update(long id, ParkingPlaceDtoRequest request) {
        var parkingPlace = parkingPlaceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingPlace with ID = " + id + " in Database."));
        create(id, request);
        return parkingPlace;
    }

    @Transactional
    public ParkingPlace deleteById(long id) {
        var parkingPlace = parkingPlaceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no ParkingPlace with ID = " + id + " in Database."));
        parkingPlaceRepository.deleteById(id);
        return parkingPlace;
    }
}