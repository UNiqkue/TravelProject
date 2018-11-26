package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.TypeTour;

import java.util.*;

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
        return null;
    }

    public List<Tour> getByName(String name) {
        return new ArrayList<>();
    }

    public List<Tour> getByDate(Date startDate, Date endDate) {
        return new ArrayList<>();
    }

    public List<Tour> getByCountry(String country) {
        return new ArrayList<>();
    }

    public List<Tour> getByType(Set<TypeTour> type) {
        return new ArrayList<>();
    }

    public List<Tour> getAll() {
        List<Tour> list = new ArrayList<Tour>();
        return list;
    }

    public Tour save(Tour tour) {
        return tour;
    }

    public Tour update(Tour tour) {
        return tour;
    }

    public void delete(UUID id) {
    }

    public List<Tour> getToursById(UUID customerId) {
        return new ArrayList<>();
    }

}

