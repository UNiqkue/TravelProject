package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;

import java.util.Collection;
import java.util.UUID;


public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

    @Override
    public TravelAgent getById(UUID id) {
        return null;
    }

    @Override
    public Collection<TravelAgent> getByName(String name) {
        return null;
    }

    @Override
    public Collection<TravelAgent> getAll() {
        return null;
    }

    @Override
    public TravelAgent save(TravelAgent travelAgent) {
        return null;
    }

    @Override
    public TravelAgent update(TravelAgent travelAgent) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

}
