package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;

import java.util.*;
import java.util.stream.Collectors;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

    private Map<UUID, TravelAgency> travelAgencyMap = getEntity();

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

    public Collection<TravelAgency> getEntityMapValues(){
        return travelAgencyMap.values();
    }

    private Map getEntity(){
        return AbstractDao.entityMap;
    }

    public TravelAgency getById(UUID id) {
        return travelAgencyMap.get(id);
    }

    public Collection<TravelAgency> getByName(String name) {

        return getEntityMapValues()
                .stream()
                .filter(travelAgency -> travelAgency.getName().equals(name))
                .collect(Collectors.toList());
    }

    public Collection<TravelAgency> getAll() {
        return getEntityMapValues();
    }

    public void save(TravelAgency travelAgency) {
        if(travelAgencyMap.isEmpty()){
            travelAgency.setId(UUID.randomUUID());
            travelAgencyMap.get(travelAgency.getId());
        }

    }

    public TravelAgency update(TravelAgency travelAgency) {
        travelAgencyMap.put(travelAgency.getId(), travelAgency);
        return travelAgency;

    }

    public void delete(UUID id) {
        travelAgencyMap.remove(id);
    }
}
