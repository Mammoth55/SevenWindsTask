package com.example.sevenwindstask.mapper;

import com.example.sevenwindstask.dto.response.UserDtoResponse;
import com.example.sevenwindstask.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDtoResponse dtoResponseFromUser(User user);
}