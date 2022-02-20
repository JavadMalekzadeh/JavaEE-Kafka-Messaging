package com.example.demo_kafka.services.interfaces;

import com.example.demo_kafka.services.dtos.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserById(UUID uuid);
    UserDto create(UserDto userDto);
}
