package com.sigma.task.mapper;

import com.sigma.task.dto.response.UserDtoResponse;
import com.sigma.task.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDtoResponse dtoResponseFromUser(User user);
}