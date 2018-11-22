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

    /**
     * String to EnumType
     **/
    public List<Tour> getByType(String type) {
        return getAll()
                .stream()
                .filter(tour -> tour.getType().equals(type))
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
        ///
        return tour;
    }

    public void delete(UUID id) {
        List<Tour> list = getAll();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                System.out.println("Tour found");
                break;
            }
        }
        list.remove(i);
        try {
            TourList tourList = new TourList();
            tourList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
        for (i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    public List<Tour> getToursById(UUID customerId) {
        return getAll()
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
