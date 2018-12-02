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
        return null;
    }

    public List<Tour> getByName(String name) {
        return null;
    }

    public List<Tour> getByDate(Date startDate, Date endDate) {
        return null;
    }

    public List<Tour> getByCountry(String country) {
        return null;
    }

    public List<Tour> getByType(String type) {
        return null;
    }

    public List<Tour> getByTravelAgencyId(UUID id) {
        return null;
    }


    public List<Tour> getAll() {
        return null;
    }

    public Tour save(Tour tour) {
        return tour;
    }

    public Tour update(Tour tour) {
        return tour;
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public Tour removeById(UUID id) {
        return null;
    }


}

