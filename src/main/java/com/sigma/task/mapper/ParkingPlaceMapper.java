package com.sigma.task.mapper;

import com.sigma.task.dto.response.ParkingPlaceDtoResponse;
import com.sigma.task.model.ParkingPlace;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ParkingPlaceMapper {

    ParkingPlaceMapper PARKING_PLACE_MAPPER = Mappers.getMapper(ParkingPlaceMapper.class);

    ParkingPlaceDtoResponse dtoResponseFromParkingPlace(ParkingPlace parkingPlace);
}