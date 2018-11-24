package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.TourList;
import com.netcracker.travel.entity.Tour;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TourDaoImpl implements AbstractDao<Tour> {

    private static volatile TourDaoImpl instance;

    private TourDaoImpl() {
    }

    public static TourDaoImpl getInstance() {
        if (instance == null) {
            synchronized (TourDaoImpl.class) {
                if (instance == null) {
                    instance = new TourDaoImpl();
                }
            }
        }
        return instance;
    }

    public Tour getById(UUID id) {
        return getAll()
                .stream()
                .filter(tour -> tour.getId().toString().equals(id.toString()))
                .findFirst().get();
    }

    public List<Tour> getByName(String name) {
        return getAll()
                .stream()
                .filter(tour -> tour.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Tour> getByDate(Date startDate, Date endDate) {
        return getAll()
                .stream()
                .filter(tour -> tour.getStartDate().equals(startDate))
                .filter(tour -> tour.getEndDate().equals(endDate))
                .collect(Collectors.toList());
    }

    public List<Tour> getByCountry(String country) {
        return getAll()
                .stream()
                .filter(tour -> tour.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<Tour> getByType(String type) {
        return getAll()
                .stream()
                .filter(tour -> tour.getType().toString().equals(type))
                .collect(Collectors.toList());
    }

    public List<Tour> getByTravelAgencyId(UUID id) {
        return getAll()
                .stream()
                .filter(tour -> tour.getTravelAgencyId().toString().equals(id.toString()))
                .collect(Collectors.toList());
    }


    public List<Tour> getAll() {
        TourList list = new TourList();
        return list.read();
    }

    public Tour save(Tour tour) {
        TourList list = new TourList();
        return list.write(tour);
    }

    public Tour update(Tour tour) {
        removeById(tour.getId());
        return save(tour);
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public Tour removeById(UUID id) {
        List<Tour> list = getAll();
        Tour tour = new Tour();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                tour = list.remove(i);
                System.out.println("Tour found");
                break;
            }
        }
        saveList(list);
        return tour;
    }

    private void saveList(List<Tour> list) {
        clean();
        for (int i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    private void clean() {
        TourList tourList = new TourList();
        try {
            tourList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
    }


    public List<Tour> getToursById(UUID customerId) {
        return getAll()
                .stream()
                .filter(tour -> tour.getCustomerId().toString().equals(customerId.toString()))
                .collect(Collectors.toList());
    }


}

