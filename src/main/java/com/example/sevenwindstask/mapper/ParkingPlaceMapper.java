package com.example.sevenwindstask.mapper;

import com.example.sevenwindstask.dto.response.ParkingPlaceDtoResponse;
import com.example.sevenwindstask.dto.response.UserDtoResponse;
import com.example.sevenwindstask.model.ParkingPlace;
import com.example.sevenwindstask.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ParkingPlaceMapper {

    ParkingPlaceMapper PARKING_PLACE_MAPPER = Mappers.getMapper(ParkingPlaceMapper.class);

    ParkingPlaceDtoResponse dtoResponseFromParkingPlace(ParkingPlace parkingPlace);
}