package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\travelagency.json";

    private static volatile TravelAgencyDaoImpl instance;

    private TravelAgencyDaoImpl(){}

    public static TravelAgencyDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TravelAgencyDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgencyDaoImpl();
                }
            }
        }
        return instance;
    }

    public TravelAgency getById(UUID id) {
        return getAll()
                .stream()
                .filter(travelAgency -> travelAgency.getId().toString().equals(id.toString()))
                .collect(Collectors.toList()).get(0);
    }

    public List<TravelAgency> getByName(String name) {
        return getAll()
                .stream()
                .filter(travelAgency -> travelAgency.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<TravelAgency> getAll() {
        List<TravelAgency> list = new ArrayList<TravelAgency>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                TravelAgency travelAgency = new TravelAgency();
                JSONObject jsonObject = new JSONObject(scanner.nextLine());
                travelAgency.setId(UUID.fromString(jsonObject.get("id").toString()));
                travelAgency.setName((String) jsonObject.get("name"));
                travelAgency.setCountTour(Integer.valueOf(jsonObject.get("countTour").toString()));
                travelAgency.setCountTravelAgent(Integer.valueOf(jsonObject.get("countTravelAgent").toString()));
                list.add(travelAgency);
            }
            scanner.close();
        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
        } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
        }
        return list;
    }

    public TravelAgency save(TravelAgency travelAgency) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonTravelAgency = new JSONObject();
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
            fileWriter.flush();
            fileWriter.close();
        } catch(JSONException e1) {
            e1.printStackTrace();
        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "File not found ");
        } catch(IOException ioe){
            System.out.println("Error while writing to file: " + ioe);
        }
        return travelAgency;
    }

    public TravelAgency update(TravelAgency travelAgency) {
        ///
        return travelAgency;
    }

    public void delete(UUID id) {
        List<TravelAgency> list = getAll();
        int i;
        for(i=0; i<=list.size()-1; i++){
            if(list.get(i).getId().toString().equals(id.toString())){
                System.out.println("TravelAgency found");
                break;
            }
        }
        list.remove(i);
        try {
            clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
        for(i=0; i<=list.size()-1; i++){
            save(list.get(i));
        }
    }

    private void clean() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }

}
