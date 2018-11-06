package com.netcracker.travel.daos.implementation;

import com.netcracker.travel.daos.interfaces.AbstractDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TravelAgentDaoImpl<TravelAgent> implements AbstractDao<TravelAgent> {

    private List<TravelAgent> travelAgents = new ArrayList<>();
    
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

    public TravelAgent getByName(String name) {
        return null;
    }

    public List<TravelAgent> getAll() {
        return null;
    }

    public TravelAgent save(TravelAgent travelAgent) {
        return null;
    }

    public void update(TravelAgent travelAgent) {
    }

    public void delete(UUID id) {
    }
}
