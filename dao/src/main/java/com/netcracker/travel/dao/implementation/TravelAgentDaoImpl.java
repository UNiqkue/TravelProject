package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.TravelAgentList;
import com.netcracker.travel.entity.TravelAgent;

<<<<<<< HEAD
import java.util.*;
=======
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
>>>>>>> task3

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
<<<<<<< HEAD
        return null;
    }

    public List<TravelAgent> getByName(String lastName) {
        return new ArrayList<>();
=======
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
>>>>>>> task3
    }

    public TravelAgent getByUsername(String username) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getUsername().equals(username))
                .findFirst().get();
    }

    public List<TravelAgent> getAll() {
<<<<<<< HEAD

        return new ArrayList<>();
    }

    public TravelAgent save(TravelAgent travelAgent) {
        return null;
    }

    public TravelAgent update(TravelAgent travelAgent) {

        return null;
    }

    public void delete(UUID id) {
    }

    public TravelAgent getByUsername(String username) {

        return null;
=======
        TravelAgentList list = new TravelAgentList();
        return list.read();
    }

    public TravelAgent save(TravelAgent travelAgent) {
        TravelAgentList list = new TravelAgentList();
        return list.write(travelAgent);
    }

    public TravelAgent update(TravelAgent travelAgent) {
        removeById(travelAgent.getId());
        return save(travelAgent);
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public TravelAgent removeById(UUID id) {
        List<TravelAgent> list = getAll();
        TravelAgent travelAgent = new TravelAgent();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                travelAgent = list.remove(i);
                System.out.println("TravelAgent found");
                break;
            }
        }
        saveList(list);
        return travelAgent;
>>>>>>> task3
    }

    private void saveList(List<TravelAgent> list) {
        clean();
        for (int i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    private void clean() {
        TravelAgentList travelAgentList = new TravelAgentList();
        try {
            travelAgentList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
    }


}
