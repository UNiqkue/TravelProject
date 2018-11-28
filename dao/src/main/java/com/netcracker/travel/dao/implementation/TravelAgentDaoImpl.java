package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;

import java.util.List;
import java.util.UUID;

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
        return null;
    }

    public List<TravelAgent> getAll() {
        return null;
    }

    public TravelAgent save(TravelAgent travelAgent) {
        return travelAgent;
    }

    public TravelAgent update(TravelAgent travelAgent) {
        return travelAgent;
    }

    public void delete(UUID id) {

    }



}
