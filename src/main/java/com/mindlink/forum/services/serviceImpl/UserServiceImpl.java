package com.mindlink.forum.services.serviceImpl;

import com.mindlink.forum.models.DTO.UserDtos.UpdateUserDto;
import com.mindlink.forum.models.DTO.UserDtos.UserCreateDto;
import com.mindlink.forum.models.DTO.UserDtos.UserGetDto;
import com.mindlink.forum.models.User;
import com.mindlink.forum.repositories.UserRepository;
import com.mindlink.forum.services.UserService;
import com.mindlink.forum.utils.MapperUserDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private MapperUserDemo mapperTest;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserGetDto createUser(UserCreateDto user) {
        User userEntity = new User(user.getUsername());
        User savedUser = userRepository.save(userEntity);
        return mapperTest.toUserDtoGet(savedUser);
    }

    @Override
    public UserGetDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return mapperTest.toUserDtoGet(user.get());
        }
        return null;
    }

    @Override
    public List<UserGetDto> getAllUsers() {
        List<UserGetDto> users = mapperTest.toUsersDtoGet(userRepository.findAll());
        return users;
    }

    @Override
    public UserGetDto updateUser(Long id, UpdateUserDto userdto) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isPresent()) {
            userToUpdate.get().setUsername(userdto.getUsername());
            User updatedUser = userRepository.save(userToUpdate.get());
            return mapperTest.toUserDtoGet(updatedUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
