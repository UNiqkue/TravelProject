package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;

import java.util.List;
import java.util.UUID;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

    private static volatile TravelAgencyDaoImpl instance;

    private TravelAgencyDaoImpl() {
    }

    public static TravelAgencyDaoImpl getInstance() {
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

    public List<TravelAgency> getByName(String name) {
        return null;
    }

    public List<TravelAgency> getAll() {
        return null;
    }

    public TravelAgency save(TravelAgency travelAgency) {
        return travelAgency;
    }

    public TravelAgency update(TravelAgency travelAgency) {
        return travelAgency;
    }

    public void delete(UUID id) {
    }

    public TravelAgency removeById(UUID id) {
        return null;
    }

}
