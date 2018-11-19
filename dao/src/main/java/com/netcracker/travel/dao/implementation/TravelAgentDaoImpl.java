package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;

import java.util.*;
import java.util.stream.Collectors;

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\travelagent.json";

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
        Map<UUID, TravelAgent> travelAgentMap = new HashMap<>();
        return travelAgentMap.get(id);
    }

    public List<TravelAgent> getByName(String lastName) {
        Map<UUID, TravelAgent> travelAgentMap = new HashMap<>();
        return travelAgentMap.values()
                .stream()
                .filter(travelAgent -> travelAgent.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<TravelAgent> getAll() {
        Map<UUID, TravelAgent> travelAgentMap = new HashMap<>();
        return new ArrayList<>(travelAgentMap.values());
    }

    public TravelAgent save(TravelAgent travelAgent) {
        Map<UUID, TravelAgent> travelAgentMap = new HashMap<>();
        if(travelAgentMap.isEmpty()){
            travelAgent.setId(UUID.randomUUID());
            travelAgentMap.get(travelAgent.getId());
        }
        return travelAgent;
    }

    public TravelAgent update(TravelAgent travelAgent) {
        Map<UUID, TravelAgent> travelAgentMap = new HashMap<>();
        travelAgentMap.put(travelAgent.getId(), travelAgent);
        return travelAgent;
    }

    public void delete(UUID id) {
        Map<UUID, TravelAgent> travelAgentMap = new HashMap<>();
        travelAgentMap.remove(id);
    }

    public TravelAgent getByUsername(String username) {
        Map<UUID, TravelAgent> customerMap = new HashMap<>();
        return (TravelAgent) customerMap.values()
                .stream()
                .filter(customer -> customer.getUsername().equals(username));
    }



}
