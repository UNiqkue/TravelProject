package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

    private Map<Integer, TravelAgent> travelAgents = new HashMap<Integer, TravelAgent>();
    
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
