package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

    private Map<UUID, TravelAgent> travelAgentMap = getEntityMap();
    
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

    public Collection<TravelAgent> getEntityMapValues(){
        return travelAgentMap.values();
    }

    private Map getEntityMap(){
        return AbstractDao.entityMap;
    }

    public TravelAgent getById(UUID id) {
        return travelAgentMap.get(id);
    }

    public Collection<TravelAgent> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(travelAgent -> travelAgent.getUsername().equals(name))
                .collect(Collectors.toList());
    }

    public Collection<TravelAgent> getAll() {
        return getEntityMapValues();
    }

    public void save(TravelAgent travelAgent) {
        if(travelAgentMap.isEmpty()){
            travelAgent.setId(UUID.randomUUID());
            travelAgentMap.put(travelAgent.getId(), travelAgent);
        }
    }

    public TravelAgent update(TravelAgent travelAgent) {
        travelAgentMap.put(travelAgent.getId(), travelAgent);
        return travelAgent;
    }

    public void delete(UUID id) {
    }
}
