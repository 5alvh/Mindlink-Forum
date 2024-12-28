package com.mindlink.forum.utils;

import com.mindlink.forum.models.DTO.UserDtos.UserGetDto;
import com.mindlink.forum.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperUserDemo {
    MapperUserDemo INSTANCE = Mappers.getMapper(MapperUserDemo.class);
    UserGetDto toUserDtoGet(User user);
    List<UserGetDto> toUsersDtoGet(List<User> users);
}
