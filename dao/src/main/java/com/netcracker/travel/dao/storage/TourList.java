package com.netcracker.travel.dao.storage;

import com.netcracker.travel.entity.Tour;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TourList {


    private static String filePath = "dao\\src\\main\\resources\\storage\\tour.json";

    public List<Tour> read() {
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
//                tour.setType(TypeTour.valueOf((String) jsonObject.get("type")));
                tour.setCountry((String) jsonObject.get("country"));
                tour.setStartDate(java.sql.Date.valueOf(String.valueOf(jsonObject.get("startDate"))));
                tour.setEndDate(java.sql.Date.valueOf(String.valueOf(jsonObject.get("endDate"))));
                tour.setTravelAgencyId(UUID.fromString(jsonObject.get("travelAgencyId").toString()));
                tour.setCustomerId(UUID.fromString(jsonObject.get("customerId").toString()));
                tour.setFree((boolean) jsonObject.get("free"));
                list.add(tour);

            }
            scanner.close();

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf + "Unable to open file ");
        } catch (IOException e) {
            System.out.println("Error while reading to file: " + e);
        }
        return list;
    }

    public Tour write(Tour tour){
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonTour = new JSONObject();
            if (tour.getId() != null) {
                jsonTour.put("id", tour.getId());
            } else {
                jsonTour.put("id", UUID.randomUUID().toString());
            }
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
                jsonTour.put("travelAgencyId", "00000000-0000-0000-0000-000000000000");
            }
            if (tour.getCustomerId() != null) {
                jsonTour.put("customerId", tour.getCustomerId());
            } else {
                jsonTour.put("customerId", "00000000-0000-0000-0000-000000000000");
            }
            if (String.valueOf(tour.isFree()) != null) {
                jsonTour.put("free", tour.isFree());
            } else {
                jsonTour.put("free", "null");
            }
            fileWriter.write(jsonTour.toString() + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf + "File not found ");
        } catch (IOException ioe) {
            System.out.println("Error while writing to file: " + ioe);
        }
        return tour;
    }

    public void clean() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }
}
