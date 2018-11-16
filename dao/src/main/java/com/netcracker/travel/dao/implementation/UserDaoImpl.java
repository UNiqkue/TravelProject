package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;

import java.util.*;
import java.util.stream.Collectors;


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
        Map<UUID, User> userMap = new HashMap<>();
        return userMap.get(id);
    }

    public List<User> getByName(String name) {
        Map<UUID, User> userMap = new HashMap<>();
        return userMap.values()
                .stream()
                .filter(user -> user.getUsername().equals(name))
                .collect(Collectors.toList());
    }

    public List<User> getAll() {
        Map<UUID, User> userMap = new HashMap<>();
        return new ArrayList<>(userMap.values());
    }

    public User save(User user) {
        Map<UUID, User> userMap = new HashMap<>();
        if(userMap.isEmpty()){
            user.setId(UUID.randomUUID());
            userMap.put(user.getId(), user);
        }
        return user;
    }

    public User update(User user) {
        Map<UUID, User> userMap = new HashMap<>();
        userMap.put(user.getId(), user);
        return user;
    }

    public void delete(UUID id) {
        Map<UUID, User> userMap = new HashMap<>();
        userMap.remove(id);
    }

}
