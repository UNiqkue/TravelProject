package com.netcracker.travel.dao.storage;

import com.netcracker.travel.entity.TravelAgent;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TravelAgentList {

    private static String filePath = "dao\\src\\main\\resources\\storage\\travelagent.json";

    public List<TravelAgent> read(){
        List<TravelAgent> list = new ArrayList<TravelAgent>();
        TravelAgent travelAgent;
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                travelAgent = new TravelAgent();
                JSONObject jsonObject = new JSONObject(scanner.nextLine());

                travelAgent.setId(UUID.fromString(jsonObject.get("id").toString()));
                travelAgent.setFirstName((String) jsonObject.get("firstName"));
                travelAgent.setLastName((String) jsonObject.get("lastName"));
                travelAgent.setUsername((String) jsonObject.get("username"));
                travelAgent.setPassword((String) jsonObject.get("password"));
                travelAgent.setEmail((String) jsonObject.get("email"));
                travelAgent.setActivationCode((String) jsonObject.get("activationCode"));
                travelAgent.setPhoneNumber((String) jsonObject.get("phoneNumber"));
                travelAgent.setPosition((String) jsonObject.get("position"));
                travelAgent.setTravelAgencyId(UUID.fromString(jsonObject.get("travelAgencyId").toString()));

                list.add(travelAgent);
            }
            scanner.close();

        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
        } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
        }
        return list;
    }

    public TravelAgent write(TravelAgent travelAgent){
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonTravelAgent = new JSONObject();

            if (travelAgent.getId() != null) {
                jsonTravelAgent.put("id", travelAgent.getId());
            } else {
                jsonTravelAgent.put("id", UUID.randomUUID().toString());
            }
            if (travelAgent.getFirstName() != null) {
                jsonTravelAgent.put("firstName", travelAgent.getFirstName());
            } else {
                jsonTravelAgent.put("firstName", "null");
            }
            if (travelAgent.getLastName() != null) {
                jsonTravelAgent.put("lastName", travelAgent.getLastName());
            } else {
                jsonTravelAgent.put("lastName", "null");
            }
            if (travelAgent.getUsername() != null) {
                jsonTravelAgent.put("username", travelAgent.getUsername());
            } else {
                jsonTravelAgent.put("username", "null");
            }
            if (travelAgent.getPassword() != null) {
                jsonTravelAgent.put("password", travelAgent.getPassword());
            } else {
                jsonTravelAgent.put("password", "null");
            }
            if (travelAgent.getEmail() != null) {
                jsonTravelAgent.put("email", travelAgent.getEmail());
            } else {
                jsonTravelAgent.put("email", "null");
            }
            if (travelAgent.getActivationCode() != null) {
                jsonTravelAgent.put("activationCode", travelAgent.getActivationCode());
            } else {
                jsonTravelAgent.put("activationCode", "00000000-0000-0000-0000-000000000000");
            }
            jsonTravelAgent.put("role", travelAgent.getRole());

            if (travelAgent.getPhoneNumber() != null) {
                jsonTravelAgent.put("phoneNumber", travelAgent.getPhoneNumber());
            } else {
                jsonTravelAgent.put("phoneNumber", "+375-00-000-00-00");
            }
            if (travelAgent.getPhoneNumber() != null) {
                jsonTravelAgent.put("position", travelAgent.getPosition());
            } else {
                jsonTravelAgent.put("position", "null");
            }
            if (travelAgent.getTravelAgencyId() != null) {
                jsonTravelAgent.put("travelAgencyId", travelAgent.getTravelAgencyId());
            } else {
                jsonTravelAgent.put("travelAgencyId", "00000000-0000-0000-0000-000000000000");
            }

            fileWriter.write(jsonTravelAgent.toString() + "\n");
            fileWriter.flush();
            fileWriter.close();

        } catch(JSONException e1) {
            e1.printStackTrace();
        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "File not found ");
        } catch(IOException ioe){
            System.out.println("Error while writing to file: " + ioe);
        }
        return travelAgent;
    }


    public void clean() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }
}
