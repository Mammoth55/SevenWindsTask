package com.sigma.task.mapper;

import com.sigma.task.dto.response.ParkingPlaceDtoResponse;
import com.sigma.task.dto.response.ParkingPlaceDtoResponse.ParkingPlaceDtoResponseBuilder;
import com.sigma.task.model.ParkingPlace;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-01T18:12:58+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class ParkingPlaceMapperImpl implements ParkingPlaceMapper {

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
}
