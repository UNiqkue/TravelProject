package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\travelagent.json";

    private static volatile TravelAgentDaoImpl instance;

    private TravelAgentDaoImpl(){}

    public static TravelAgentDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TravelAgentDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgentDaoImpl();
                }
            }
        }
        return instance;
    }

    public TravelAgent getById(UUID id) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getId().toString().equals(id.toString()))
                .collect(Collectors.toList()).get(0);
    }

    public List<TravelAgent> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<TravelAgent> getAll() {
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
                travelAgent.setPosition((String) jsonObject.get("phoneNumber"));
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

    public TravelAgent save(TravelAgent travelAgent) {
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
                jsonTravelAgent.put("activationCode", "null");
            }
            jsonTravelAgent.put("role", travelAgent.getRole());

            if (travelAgent.getPhoneNumber() != null) {
                jsonTravelAgent.put("phoneNumber", travelAgent.getPhoneNumber());
            } else {
                jsonTravelAgent.put("phoneNumber", "null");
            }
            if (travelAgent.getTravelAgencyId() != null) {
                jsonTravelAgent.put("customerId", travelAgent.getTravelAgencyId());
            } else {
                jsonTravelAgent.put("customerId", "00000000-0000-0000-0000-000000000000");
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

    public TravelAgent update(TravelAgent travelAgent) {
        ///
        return travelAgent;
    }

    public void delete(UUID id) {
        List<TravelAgent> list = getAll();
        int i;
        for(i=0; i<=list.size()-1; i++){
            if(list.get(i).getId().toString().equals(id.toString())){
                System.out.println("TravelAgent found");
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

    public TravelAgent getByUsername(String username) {
        Map<UUID, TravelAgent> travelAgentMap = new HashMap<>();
        return (TravelAgent) travelAgentMap.values()
                .stream()
                .filter(travelAgent -> travelAgent.getUsername().equals(username));
    }

    private void clean() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }

}
