package com.sigma.task.mapper;

import com.sigma.task.dto.response.ParkingPlaceDtoResponse;
import com.sigma.task.dto.response.ParkingPlaceDtoResponse.ParkingPlaceDtoResponseBuilder;
import com.sigma.task.dto.response.ParkingTicketDtoResponse;
import com.sigma.task.dto.response.ParkingTicketDtoResponse.ParkingTicketDtoResponseBuilder;
import com.sigma.task.dto.response.UserDtoResponse;
import com.sigma.task.dto.response.UserDtoResponse.UserDtoResponseBuilder;
import com.sigma.task.model.ParkingPlace;
import com.sigma.task.model.ParkingTicket;
import com.sigma.task.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-01T18:12:58+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class ParkingTicketMapperImpl implements ParkingTicketMapper {

    @Override
    public ParkingTicketDtoResponse dtoResponseFromParkingTicket(ParkingTicket parkingTicket) {
        if ( parkingTicket == null ) {
            return null;
        }

        ParkingTicketDtoResponseBuilder parkingTicketDtoResponse = ParkingTicketDtoResponse.builder();

        parkingTicketDtoResponse.parkingPlaceDtoResponse( dtoResponseFromParkingPlace( parkingTicket.getParkingPlace() ) );
        parkingTicketDtoResponse.userDtoResponse( dtoResponseFromUser( parkingTicket.getUser() ) );
        parkingTicketDtoResponse.id( parkingTicket.getId() );
        if ( parkingTicket.getStartTime() != null ) {
            parkingTicketDtoResponse.startTime( parkingTicket.getStartTime().toString() );
        }
        parkingTicketDtoResponse.durationInMinutes( parkingTicket.getDurationInMinutes() );
        parkingTicketDtoResponse.prepaid( parkingTicket.isPrepaid() );

        return parkingTicketDtoResponse.build();
    }

    @Override
    public ParkingPlaceDtoResponse dtoResponseFromParkingPlace(ParkingPlace parkingPlace) {
        if ( parkingPlace == null ) {
            return null;
        }

        ParkingPlaceDtoResponseBuilder parkingPlaceDtoResponse = ParkingPlaceDtoResponse.builder();

        parkingPlaceDtoResponse.id( parkingPlace.getId() );
        parkingPlaceDtoResponse.number( parkingPlace.getNumber() );
        if ( parkingPlace.getStatus() != null ) {
            parkingPlaceDtoResponse.status( parkingPlace.getStatus().name() );
        }
        parkingPlaceDtoResponse.price( parkingPlace.getPrice() );

        return parkingPlaceDtoResponse.build();
    }

    @Override
    public UserDtoResponse dtoResponseFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoResponseBuilder userDtoResponse = UserDtoResponse.builder();

        userDtoResponse.id( user.getId() );
        userDtoResponse.firstName( user.getFirstName() );
        userDtoResponse.middleName( user.getMiddleName() );
        userDtoResponse.lastName( user.getLastName() );
        userDtoResponse.email( user.getEmail() );
        userDtoResponse.phoneNumber( user.getPhoneNumber() );
        userDtoResponse.carNumber( user.getCarNumber() );
        userDtoResponse.carModel( user.getCarModel() );

        return userDtoResponse.build();
    }
}
