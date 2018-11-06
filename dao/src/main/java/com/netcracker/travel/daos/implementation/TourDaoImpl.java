package com.netcracker.travel.daos.implementation;

import com.netcracker.travel.entity.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class TourDaoImpl{ //implements AbstractDao<Tour> {

    private List<Tour> tours = new ArrayList<>();

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

        return null;
    }

    public Tour getByName(String name) {
        return null;
    }

    public List<Tour> getAll() {

        return tours.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public String save(Tour tour) {
        tours.add(tour);
        tour.setId(UUID.randomUUID());
        return tour.getId().toString();
    }

    public void update(Tour tour) {
        tours.set(tours.indexOf(tour), tour);
    }

    public void delete(Tour tour) {
        tours.set(tours.indexOf(tour), null);
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
