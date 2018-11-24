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

    public Tour getByTravelAgencyId(UUID id) {
        return getAll()
                .stream()
                .filter(tour -> tour.getTravelAgencyId().toString().equals(id.toString()))
                .findFirst().get();
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

/*{"country":"null","endDate":"2000-11-11","travelAgencyId":"28f9d5dd-83ba-4056-a0dd-ed1ca736a6ce","price":15.0,"name":"null","customerId":"ec1e0615-04f1-402a-ac9e-51775feb5760","description":"null","id":"0a876ff1-333e-4031-8735-3076b550be72","type":"HOTELRESTTOUR","free":true,"startDate":"2000-10-10"}
{"country":"null","endDate":"2000-11-11","travelAgencyId":"47636e55-9b16-4808-a342-9f3e02ac3db8","price":16.0,"name":"null","customerId":"96338867-4e04-4609-98aa-5300e9e80d3a","description":"null","id":"f01dc2bf-a20a-4da7-8cbd-96d22e69cbba","type":"HOTELRESTTOUR","free":true,"startDate":"2000-10-10"}
{"country":"null","endDate":"2000-11-11","travelAgencyId":"00000000-0000-0000-0000-000000000000","price":17.0,"name":"null","customerId":"00000000-0000-0000-0000-000000000000","description":"null","id":"a8828cbf-44b0-4a36-93b3-ecd9cc4bd93e","type":"HOTELRESTTOUR","free":true,"startDate":"2000-10-10"}
{"country":"null","endDate":"2000-11-11","travelAgencyId":"00000000-0000-0000-0000-000000000000","price":18.0,"name":"null","customerId":"00000000-0000-0000-0000-000000000000","description":"null","id":"4398a453-5857-4d8c-9a06-7a5296c5eb4b","type":"HOTELRESTTOUR","free":true,"startDate":"2000-10-10"}*/
