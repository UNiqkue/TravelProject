package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Tour;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class TourDaoImpl implements AbstractDao<Tour> {

    private Map<UUID, Tour> tourMap = getEntityMap();

    private static volatile TourDaoImpl instance;

    private TourDaoImpl(){}

    public static TourDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TourDaoImpl.class) {
                if (instance == null) {
                    instance = new TourDaoImpl();
                }
            }
        }
        return instance;
    }

    public Collection<Tour> getEntityMapValues(){
        return tourMap.values();
    }

    private Map getEntityMap() {
        return AbstractDao.entityMap;
    }

    public Tour getById(UUID id) {
        return tourMap.get(id);
    }

    public Collection<Tour> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(tour -> tour.getName().equals(name))
                .collect(Collectors.toList());
    }


    public Collection<Tour> getAll() {
        return getEntityMapValues();
    }

    public void save(Tour tour) {
        if (tourMap.isEmpty()) {
            tour.setId(UUID.randomUUID());
            tourMap.put(tour.getId(), tour); 
        }
    }

    public Tour update(Tour tour) {
        tourMap.put(tour.getId(), tour);
        return tour;
    }

    public void delete(UUID id) {
        tourMap.remove(id);
    }
}

/*
 tours.add(new Tour(UUID.randomUUID().toString(), "Тур с отдыхом в Испании на 12 дней",
                    "Раннее бронирование до 1-го марта. 8 дней на море в Испании+Барселона",
                         310.0, Collections.singleton(TypeTour.CRUISE), "Испания",
                             Date.valueOf("2018-10-28"), Date.valueOf("2018-11-07")));
        tours.add(new Tour(UUID.randomUUID().toString(),"Тур в Португалию на 14 дней",
                "Раннее бронирование до 1-го марта. Эксклюзив! Франкфурт-Париж-Мадрид-6 дней в Португалии-Барселона-Женева-Страсбург.",
                475.0, Collections.singleton(TypeTour.EXCURSION), "Португалия",
                Date.valueOf("2018-10-30"), Date.valueOf("2018-11-13")));
        tours.add(new Tour(UUID.randomUUID().toString();,"Отдых на Крите",
                "самый большой остров в Греции и пятый по величине в Средиземноморье.",
                999.50, Collections.singleton(TypeTour.HOTELRESTTOUR), "Greece",
                Date.valueOf("2019-06-20"), Date.valueOf("2019-07-04")));
 */
