package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;

import java.util.*;
import java.util.stream.Collectors;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

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
        Map<UUID, TravelAgency> travelAgencyMap = new HashMap<>();
        return travelAgencyMap.get(id);
    }

    public List<TravelAgency> getByName(String name) {
        Map<UUID, TravelAgency> travelAgencyMap = new HashMap<>();
        return travelAgencyMap.values()
                .stream()
                .filter(travelAgency -> travelAgency.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<TravelAgency> getAll() {
        Map<UUID, TravelAgency> travelAgencyMap = new HashMap<>();
        return new ArrayList<>(travelAgencyMap.values());
    }

    public TravelAgency save(TravelAgency travelAgency) {
        Map<UUID, TravelAgency> travelAgencyMap = new HashMap<>();
        if(travelAgencyMap.isEmpty()){
            travelAgency.setId(UUID.randomUUID());
            travelAgencyMap.get(travelAgency.getId());
        }
        return travelAgency;
    }

    public TravelAgency update(TravelAgency travelAgency) {
        Map<UUID, TravelAgency> travelAgencyMap = new HashMap<>();
        travelAgencyMap.put(travelAgency.getId(), travelAgency);
        return travelAgency;
    }

    public void delete(UUID id) {
        Map<UUID, TravelAgency> travelAgencyMap = new HashMap<>();
        travelAgencyMap.remove(id);
    }


}
