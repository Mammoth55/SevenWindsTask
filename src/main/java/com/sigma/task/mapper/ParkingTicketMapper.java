package com.sigma.task.mapper;

import com.sigma.task.dto.response.ParkingPlaceDtoResponse;
import com.sigma.task.dto.response.ParkingTicketDtoResponse;
import com.sigma.task.dto.response.UserDtoResponse;
import com.sigma.task.model.ParkingPlace;
import com.sigma.task.model.ParkingTicket;
import com.sigma.task.model.User;
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