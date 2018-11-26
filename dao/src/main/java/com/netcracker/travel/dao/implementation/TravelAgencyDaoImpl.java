package com.netcracker.travel.dao.implementation;


import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;

import java.util.Collection;
import java.util.UUID;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {


    @Override
    public TravelAgency getById(UUID id) {
        return null;
    }

    @Override
    public Collection<TravelAgency> getByName(String name) {
        return null;
    }

    @Override
    public Collection<TravelAgency> getAll() {
        return null;
    }

    @Override
    public TravelAgency save(TravelAgency travelAgency) {
        return null;
    }

    @Override
    public TravelAgency update(TravelAgency travelAgency) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
