package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Tour;

import java.util.*;
import java.util.stream.Collectors;

public class TourDaoImpl implements AbstractDao<Tour> {

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

    public Tour getById(UUID id) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        return tourMap.get(id);
    }

    public List<Tour> getByName(String name) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        return tourMap.values()
                .stream()
                .filter(tour -> tour.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Tour> getByDate(Date startDate, Date endDate) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        return tourMap.values()
                .stream()
                .filter(tour -> tour.getStartDate().equals(startDate))
                .filter(tour -> tour.getEndDate().equals(endDate))
                .collect(Collectors.toList());
    }

    public List<Tour> getByCountry(String country) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        return tourMap.values()
                .stream()
                .filter(tour -> tour.getCountry().equals(country))
                .collect(Collectors.toList());
    }

            /**String to EnumType**/
    public List<Tour> getByType(String type) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        return tourMap.values()
                .stream()
                .filter(tour -> tour.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Tour> getAll() {
        Map<UUID, Tour> tourMap = new HashMap<>();
        return new ArrayList<>(tourMap.values());
    }

    public Tour save(Tour tour) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        if (tourMap.isEmpty()) {
            tour.setId(UUID.randomUUID());
            tourMap.put(tour.getId(), tour);
        }
        return tour;
    }

    public Tour update(Tour tour) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        tourMap.put(tour.getId(), tour);
        return tour;
    }

    public void delete(UUID id) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        tourMap.remove(id);
    }

    public List<Tour> getToursById(UUID customerId) {
        Map<UUID, Tour> tourMap = new HashMap<>();
        return tourMap.values()
                .stream()
                .filter(tour -> tour.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
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
