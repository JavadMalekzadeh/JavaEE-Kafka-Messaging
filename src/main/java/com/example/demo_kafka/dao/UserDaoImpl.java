package com.example.demo_kafka.dao;

import com.example.demo_kafka.dao.interfaces.UserDao;
import com.example.demo_kafka.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;
@Stateless
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createNamedQuery(User.QUERY_FIND_ALL).getResultList();
    }

    @Override
    public User getUserById(UUID uuid) {
        return entityManager.find(User.class,uuid);
    }

    @Override
    public User create(User user) {
        return entityManager.merge(user);
    }
}
