package com.mindlink.forum.services;

import com.mindlink.forum.models.DTO.UserDtos.UpdateUserDto;
import com.mindlink.forum.models.DTO.UserDtos.UserCreateDto;
import com.mindlink.forum.models.DTO.UserDtos.UserGetDto;

import java.util.List;

public interface UserService {
    UserGetDto createUser(UserCreateDto user);
    UserGetDto getUserById(Long id);
    List<UserGetDto> getAllUsers();
    UserGetDto updateUser(Long id, UpdateUserDto user);
    void deleteUser(Long id);
}
