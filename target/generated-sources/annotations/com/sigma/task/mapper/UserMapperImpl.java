package com.sigma.task.mapper;

import com.sigma.task.dto.response.UserDtoResponse;
import com.sigma.task.dto.response.UserDtoResponse.UserDtoResponseBuilder;
import com.sigma.task.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-01T18:12:57+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

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
