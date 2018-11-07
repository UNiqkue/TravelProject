package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class UserDaoImpl implements AbstractDao<User> {

    private Map<Integer, User> users = new HashMap<Integer, User>();

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
