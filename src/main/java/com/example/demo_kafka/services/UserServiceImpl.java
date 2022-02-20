package com.example.demo_kafka.services;

import com.example.demo_kafka.dao.interfaces.UserDao;
import com.example.demo_kafka.domain.User;
import com.example.demo_kafka.messaging.EventSource;
import com.example.demo_kafka.messaging.events.MessageEvent;
import com.example.demo_kafka.services.dtos.UserDto;
import com.example.demo_kafka.services.interfaces.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Stateless
public class UserServiceImpl implements UserService {
    @EJB
    private UserDao userDao;

    @Inject
    private EventSource eventSource;

    @Override
    public List<UserDto> getUsers() {
        return userDao.getUsers()
                .stream().map(x->new UserDto(x.getId(),x.getFirstName(),x.getLastName(),
                        x.getAge(),x.getUserName(),x.getPassword(),x.getCreated(),
                        x.getUpdated())).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(UUID uuid) {
        User user= userDao.getUserById(uuid);
        if(user!=null){
            return new UserDto(user.getId(),user.getFirstName(),user.getLastName(),
                    user.getAge(),user.getUserName(),user.getPassword(),
                    user.getCreated(),user.getUpdated());
        }
        throw new EntityExistsException("user not found!");
    }

    @Override
    public UserDto create(UserDto userDto) {

        User user= userDao.create(userDto.userBuilder());

        eventSource.fireEvent(new MessageEvent("create user",user.getFirstName(),
                    user.getLastName(),user.getUserName(),user.getPassword()));

        return new UserDto(user.getId(),user.getFirstName(),user.getLastName(),
                        user.getAge(),user.getUserName(),user.getPassword(),
                        user.getCreated(),user.getUpdated());

    }
}
