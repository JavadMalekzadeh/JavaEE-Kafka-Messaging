package com.example.demo_kafka.dao.interfaces;

import com.example.demo_kafka.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    List<User> getUsers();
    User getUserById(UUID uuid);
    User create(User user);
}
