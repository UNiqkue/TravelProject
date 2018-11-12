package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


public class UserDaoImpl implements AbstractDao<User> {

    private Map<UUID, User> userMap = getEntityMap();

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

    public Collection<User> getEntityMapValues(){
        return userMap.values();
    }

    private Map getEntityMap() {
        return AbstractDao.entityMap;
    }

    public User getById(UUID id) {
        return userMap.get(id);
    }

    public Collection<User> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(user -> user.getUsername().equals(name))
                .collect(Collectors.toList());
    }

    public Collection<User> getAll() {
        return getEntityMapValues();
    }

    public void save(User user) {
        if(userMap.isEmpty()){
            user.setId(UUID.randomUUID());
            userMap.put(user.getId(), user);
        }
    }

    public User update(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public void delete(UUID id) {
        userMap.remove(id);
    }

}
