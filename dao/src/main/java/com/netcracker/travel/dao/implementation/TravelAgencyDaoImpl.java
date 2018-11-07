package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;

import java.util.*;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

    private Map<Integer, TravelAgency> travelAgencies = new HashMap<Integer, TravelAgency>();

    private static volatile TravelAgencyDaoImpl instance;

    private TravelAgencyDaoImpl(){}

    public static TravelAgencyDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TravelAgencyDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgencyDaoImpl();
                }
            }
        }
        return instance;
    }

    public TravelAgency getById(UUID id) {
        return null;
    }

    public TravelAgency getByName(String name) {
        return null;
    }

    public List<TravelAgency> getAll() {
        return null;
    }

    public TravelAgency save(TravelAgency travelAgency) {
        return null;
    }

    public void update(TravelAgency travelAgency) {
    }

    public void delete(UUID id) {
    }
}
