package com.netcracker.travel.daos.implementation;

import com.netcracker.travel.entity.User;
import com.netcracker.travel.daos.interfaces.AbstractDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserDaoImpl<T> implements AbstractDao<User> {

    private List<User> users = new ArrayList<>();

    private static volatile UserDaoImpl instance;

    private UserDaoImpl(){}

    public static UserDaoImpl getInstance(){
        if (instance == null) {
            synchronized (UserDaoImpl.class) {
                if (instance == null) {
                    instance = new UserDaoImpl();
                }
            }
        }
        return instance;
    }

    public User getById(UUID id) {
        return null;
    }

    public User getByName(String name) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }

    public User save(User user) {
        return null;
    }

    public void update(User user) {
    }

    public void delete(UUID id) {
    }
}
