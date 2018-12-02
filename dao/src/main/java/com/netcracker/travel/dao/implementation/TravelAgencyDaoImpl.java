package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
<<<<<<< HEAD
import com.netcracker.travel.dao.storage.TravelAgencyList;
import com.netcracker.travel.entity.TravelAgency;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
=======
import com.netcracker.travel.entity.TravelAgency;

import java.util.List;
import java.util.UUID;
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

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
<<<<<<< HEAD
        return getAll()
                .stream()
                .filter(travelAgency -> travelAgency.getId().toString().equals(id.toString()))
                .findFirst().get();
    }

    public List<TravelAgency> getByName(String name) {
        return getAll()
                .stream()
                .filter(travelAgency -> travelAgency.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<TravelAgency> getAll() {
        TravelAgencyList list = new TravelAgencyList();
        return list.read();
    }

    public TravelAgency save(TravelAgency travelAgency) {
        TravelAgencyList list = new TravelAgencyList();
        return list.write(travelAgency);
    }

    public TravelAgency update(TravelAgency travelAgency) {
        removeById(travelAgency.getId());
        return save(travelAgency);
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public TravelAgency removeById(UUID id) {
        List<TravelAgency> list = getAll();
        TravelAgency travelAgency = new TravelAgency();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                travelAgency = list.remove(i);
                System.out.println("TravelAgency found");
                break;
            }
        }
        saveList(list);
        return travelAgency;
    }

    private void saveList(List<TravelAgency> list) {
        clean();
        for (int i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    private void clean() {
        TravelAgencyList travelAgencyList = new TravelAgencyList();
        try {
            travelAgencyList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
    }


=======
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

>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
}
