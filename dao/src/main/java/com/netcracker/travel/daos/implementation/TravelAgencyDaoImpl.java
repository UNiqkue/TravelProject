package com.netcracker.travel.daos.implementation;

import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.daos.interfaces.AbstractDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TravelAgencyDaoImpl<T> implements AbstractDao<TravelAgency> {

    private List<TravelAgency> travelAgencies = new ArrayList<>();

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
