package com.example.sevenwindstask.mapper;

import com.example.sevenwindstask.dto.response.ParkingPlaceDtoResponse;
import com.example.sevenwindstask.dto.response.ParkingTicketDtoResponse;
import com.example.sevenwindstask.dto.response.UserDtoResponse;
import com.example.sevenwindstask.model.ParkingPlace;
import com.example.sevenwindstask.model.ParkingTicket;
import com.example.sevenwindstask.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ParkingTicketMapper {

    ParkingTicketMapper PARKING_TICKET_MAPPER = Mappers.getMapper(ParkingTicketMapper.class);

    @Mappings({@Mapping(target = "parkingPlaceDtoResponse", source = "parkingPlace"),
            @Mapping(target = "userDtoResponse", source = "user")})
    ParkingTicketDtoResponse dtoResponseFromParkingTicket(ParkingTicket parkingTicket);

    ParkingPlaceDtoResponse dtoResponseFromParkingPlace(ParkingPlace parkingPlace);

    UserDtoResponse dtoResponseFromUser(User user);
}