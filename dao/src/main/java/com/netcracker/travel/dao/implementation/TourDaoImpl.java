package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Tour;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TourDaoImpl implements AbstractDao<Tour> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\tour.json";

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
        List<Tour> list = new ArrayList<Tour>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                Tour tour = new Tour();
                JSONObject jsonObject = new JSONObject(scanner.nextLine());

                tour.setId(UUID.fromString(jsonObject.get("id").toString()));
                tour.setName((String) jsonObject.get("name"));
                tour.setDescription((String) jsonObject.get("description"));
                tour.setPrice(Double.valueOf((String) jsonObject.get("price")));
//                tour.setType((Set<TypeTour>) jsonObject.get("type"));
                tour.setCountry((String) jsonObject.get("country"));
                tour.setStartDate(java.sql.Date.valueOf(String.valueOf(jsonObject.get("startDate"))));
                tour.setEndDate(java.sql.Date.valueOf(String.valueOf(jsonObject.get("endDate"))));
                tour.setTravelAgencyId(UUID.fromString(jsonObject.get("travelAgencyId").toString()));
                tour.setCustomerId(UUID.fromString(jsonObject.get("customerId").toString()));
                tour.setFree((boolean) jsonObject.get("free"));
                list.add(tour);

            }
            scanner.close();

        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
        } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
        }
        return list;
    }

    public Tour save(Tour tour) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonTour = new JSONObject();
            jsonTour.put("id", UUID.randomUUID().toString());
            if (tour.getName() != null) {
                jsonTour.put("name", tour.getName());
            } else {
                jsonTour.put("name", "null");
            }
            if (tour.getDescription() != null) {
                jsonTour.put("description", tour.getDescription());
            } else {
                jsonTour.put("description", "null");
            }
            if (tour.getPrice() != null) {
                jsonTour.put("price", tour.getPrice());
            } else {
                jsonTour.put("price", "100.0");
            }

            jsonTour.put("type", tour.getType());

            if (tour.getCountry() != null) {
                jsonTour.put("country", tour.getCountry());
            } else {
                jsonTour.put("country", "null");
            }
            if (tour.getStartDate() != null) {
                jsonTour.put("startDate", tour.getStartDate());
            } else {
                jsonTour.put("startDate", "2000-10-10");
            }
            if (tour.getEndDate() != null) {
                jsonTour.put("endDate", tour.getEndDate());
            } else {
                jsonTour.put("endDate", "2000-11-11");
            }
            if (tour.getTravelAgencyId() != null) {
                jsonTour.put("travelAgencyId", tour.getTravelAgencyId());
            } else {
                jsonTour.put("travelAgencyId", UUID.randomUUID().toString());
            }
            if (tour.getCustomerId() != null) {
                jsonTour.put("customerId", tour.getCustomerId());
            } else {
                jsonTour.put("customerId", UUID.randomUUID().toString());
            }
            if (String.valueOf(tour.isFree()) != null) {
                jsonTour.put("free", tour.isFree());
            } else {
                jsonTour.put("free", "null");
            }
            fileWriter.write(jsonTour.toString() + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch(JSONException e1) {
            e1.printStackTrace();
        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "File not found ");
        } catch(IOException ioe){
            System.out.println("Error while writing to file: " + ioe);
        }
        return tour;
    }

    public static void main(String[] args){
        TourDaoImpl tourDao = TourDaoImpl.getInstance();
        Tour tour = new Tour();
        tourDao.save(tour);
        List<Tour> list = tourDao.getAll();
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
        while (true){

        }
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
