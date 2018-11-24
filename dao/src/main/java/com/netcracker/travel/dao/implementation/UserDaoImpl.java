package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserDaoImpl implements AbstractDao<User> {

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

    public List<User> getByName(String lastName) {
        return new ArrayList<>();
    }

    public User getByUsername(String username) {
        return null;
    }

    public User getByEmail(String email) {
        return null;
    }

    public User getByActivationCode(String activationCode){
        return null;
    }

    public List<User> getAll() {
        return new ArrayList<>();
    }

    public User save(User user) {
        return user;
    }

    public User update(User user) {
        return user;
    }

    public void delete(UUID id) {

    }

}