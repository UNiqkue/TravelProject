package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;

import java.util.*;

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

    private static volatile TravelAgentDaoImpl instance;

    private TravelAgentDaoImpl(){}

    public static TravelAgentDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TravelAgentDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgentDaoImpl();
                }
            }
        }
        return instance;
    }

    public TravelAgent getById(UUID id) {
        return null;
    }

    public List<TravelAgent> getByName(String lastName) {
        return new ArrayList<>();
    }

    public List<TravelAgent> getAll() {

        return new ArrayList<>();
    }

    public TravelAgent save(TravelAgent travelAgent) {
        return null;
    }

    public TravelAgent update(TravelAgent travelAgent) {

        return null;
    }

    public void delete(UUID id) {
    }

    public TravelAgent getByUsername(String username) {

        return null;
    }



}
