package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.TravelAgentList;
import com.netcracker.travel.entity.TravelAgent;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

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
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getId().toString().equals(id.toString()))
                .findFirst().get();
    }

    public List<TravelAgent> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<TravelAgent> getAll() {
        TravelAgentList list = new TravelAgentList();
        return list.read();
    }

    public TravelAgent save(TravelAgent travelAgent) {
        TravelAgentList list = new TravelAgentList();
        return list.write(travelAgent);
    }

    public TravelAgent update(TravelAgent travelAgent) {
        ///
        return travelAgent;
    }

    public void delete(UUID id) {
        List<TravelAgent> list = getAll();
        int i;
        for(i=0; i<=list.size()-1; i++){
            if(list.get(i).getId().toString().equals(id.toString())){
                System.out.println("TravelAgent found");
                break;
            }
        }
        list.remove(i);
        try {
            TravelAgentList travelAgentList = new TravelAgentList();
            travelAgentList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
        for(i=0; i<=list.size()-1; i++){
            save(list.get(i));
        }
    }

    public TravelAgent getByUsername(String username) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getUsername().equals(username))
                .findFirst().get();
    }


}
