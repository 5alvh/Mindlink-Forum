package com.mindlink.forum.services.serviceImpl;

import com.mindlink.forum.models.dtos.UserDtos.UpdateUserDto;
import com.mindlink.forum.models.dtos.UserDtos.UserCreateDto;
import com.mindlink.forum.models.dtos.UserDtos.UserGetDto;
import com.mindlink.forum.models.user.User;
import com.mindlink.forum.repositories.UserRepository;
import com.mindlink.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserGetDto toUserGetDto(User user) {
        UserGetDto dto = new UserGetDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }

    private List<UserGetDto> toUserGetDtoList(List<User> users) {
        return users.stream()
                .map(this::toUserGetDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserGetDto createUser(UserCreateDto user) {
        /*User userEntity = new User();
        userEntity.setFirstName(user.getUsername());
        User savedUser = userRepository.save(userEntity);
        return toUserGetDto(savedUser); // Use manual conversion*/
        return null;
    }

    @Override
    public UserGetDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::toUserGetDto).orElse(null); // Use manual conversion
    }

    @Override
    public List<UserGetDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return toUserGetDtoList(users); // Use manual conversion
    }

    @Override
    public UserGetDto updateUser(Long id, UpdateUserDto userDto) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isPresent()) {
            userToUpdate.get().setUsername(userDto.getUsername());
            User updatedUser = userRepository.save(userToUpdate.get());
            return toUserGetDto(updatedUser); // Use manual conversion
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
