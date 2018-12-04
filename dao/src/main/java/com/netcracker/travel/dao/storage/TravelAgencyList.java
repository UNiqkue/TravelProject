package com.netcracker.travel.dao.storage;

import com.netcracker.travel.entity.TravelAgency;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TravelAgencyList {

    private static String filePath = "dao\\src\\main\\resources\\storage\\travelagency.json";
    private Scanner scanner;

    public List<TravelAgency> read() {
        List<TravelAgency> list = new ArrayList<TravelAgency>();
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                TravelAgency travelAgency = new TravelAgency();
                JSONObject jsonObject = new JSONObject(scanner.nextLine());
                travelAgency.setId(UUID.fromString(jsonObject.get("id").toString()));
                travelAgency.setName((String) jsonObject.get("name"));
                travelAgency.setCountTour(Integer.valueOf(jsonObject.get("countTour").toString()));
                travelAgency.setCountTravelAgent(Integer.valueOf(jsonObject.get("countTravelAgent").toString()));
                list.add(travelAgency);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf + "Unable to open file ");
        } finally {
            scanner.close();
        }
        return list;
    }

    public TravelAgency write(TravelAgency travelAgency) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonTravelAgency = new JSONObject();
            try {
                if (travelAgency.getId() != null) {
                    jsonTravelAgency.put("id", travelAgency.getId());
                } else {
                    jsonTravelAgency.put("id", UUID.randomUUID().toString());
                }
                if (travelAgency.getName() != null) {
                    jsonTravelAgency.put("name", travelAgency.getName());
                } else {
                    jsonTravelAgency.put("name", "null");
                }
                if (travelAgency.getCountTour() != null) {
                    jsonTravelAgency.put("countTour", travelAgency.getCountTour());
                } else {
                    jsonTravelAgency.put("countTour", "0");
                }
                if (travelAgency.getCountTravelAgent() != null) {
                    jsonTravelAgency.put("countTravelAgent", travelAgency.getCountTravelAgent());
                } else {
                    jsonTravelAgency.put("countTravelAgent", "0");
                }
                fileWriter.write(jsonTravelAgency.toString() + "\n");
            } catch (JSONException e1) {
                e1.printStackTrace();
            } finally {
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf + "File not found ");
        } catch (IOException ioe) {
            System.out.println("Error while writing to file: " + ioe);
        }
        return travelAgency;
    }

    public void clean() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }
}
