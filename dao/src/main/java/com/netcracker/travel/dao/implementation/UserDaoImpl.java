package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class UserDaoImpl implements AbstractDao<User> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\user.json";

    private static volatile UserDaoImpl instance;

    private UserDaoImpl(){}

    public static UserDaoImpl getInstance(){
        if (instance == null) {
            synchronized (UserDaoImpl.class) {
                if (instance == null) {
                    instance = new UserDaoImpl();
                }
            }
        }
        return instance;
    }

    public User getById(UUID id) {
        Map<UUID, User> userMap = new HashMap<>();
        return userMap.get(id);
    }

    public List<User> getByName(String lastName) {
        Map<UUID, User> userMap = new HashMap<>();
        return userMap.values()
                .stream()
                .filter(user -> user.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public User getByUsername(String username) {
        Map<UUID, User> userMap = new HashMap<>();
        return (User) userMap.values()
                .stream()
                .filter(user -> user.getUsername().equals(username));
    }

    public User getByEmail(String email) {
        Map<UUID, User> userMap = new HashMap<>();
        return (User) userMap.values()
                .stream()
                .filter(user -> user.getEmail().equals(email));
    }

    public User getByActivationCode(String activationCode){
        Map<UUID, User> userMap = new HashMap<>();
        return (User) userMap.values()
                .stream()
                .filter(user -> user.getActivationCode().equals(activationCode));
    }

    public List<User> getAll() {
        Map<UUID, User> userMap = new HashMap<>();
// return readEntity();
        return new ArrayList<>(userMap.values());
    }

    public User save(User user) {
        Map<UUID, User> userMap = new HashMap<>();
        if(userMap.isEmpty()){
            user.setId(UUID.randomUUID());
            userMap.put(user.getId(), user);
        }
// writeEntity(user);
        return user;
    }

    public User update(User user) {
        Map<UUID, User> userMap = new HashMap<>();
        userMap.put(user.getId(), user);
        return user;
    }

    public void delete(UUID id) {
        Map<UUID, User> userMap = new HashMap<>();
        userMap.remove(id);
    }

    public static void main(String[] args){
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        User user = new User();
        userDao.add(user);
        List<User> list = userDao.listAll();
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
        while (true){

        }
    }

    public List<User> listAll(){
        List<User> list = new ArrayList<User>();

        try {
            Scanner scanner = getScanner();
            while (scanner.hasNextLine()) {
                User user = new User();
                JSONObject jsonObject = new JSONObject(scanner.nextLine());

                user.setId(UUID.fromString(jsonObject.get("id").toString()));
                user.setFirstName((String) jsonObject.get("firstName"));
                user.setLastName((String) jsonObject.get("lastName"));
                user.setUsername((String) jsonObject.get("username"));
                user.setPassword((String) jsonObject.get("password"));
                user.setEmail((String) jsonObject.get("email"));
                user.setActivationCode((String) jsonObject.get("activationCode"));
                list.add(user);

            }
            scanner.close();

        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
        } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
        }
        return list;
    }

    public void add(User user) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonUser = new JSONObject();
            jsonUser.put("id", UUID.randomUUID().toString());
            if (user.getFirstName() != null) {
                jsonUser.put("firstName", user.getLastName());
            } else {
                jsonUser.put("firstName", "null");
            }
            if (user.getLastName() != null) {
                jsonUser.put("lastName", user.getUsername());
            } else {
                jsonUser.put("lastName", "null");
            }
            if (user.getUsername() != null) {
                jsonUser.put("username", user.getUsername());
            } else {
                jsonUser.put("username", "null");
            }
            if (user.getPassword() != null) {
                jsonUser.put("password", user.getPassword());
            } else {
                jsonUser.put("password", "null");
            }
            if (user.getEmail() != null) {
                jsonUser.put("email", user.getEmail());
            } else {
                jsonUser.put("email", "null");
            }
            if (user.getActivationCode() != null) {
                jsonUser.put("activationCode", user.getActivationCode());
            } else {
                jsonUser.put("activationCode", "null");
            }
            jsonUser.put("role", user.getRole());
            fileWriter.write(jsonUser.toString() + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch(JSONException e1) {
            e1.printStackTrace();
        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "File not found ");
        } catch(IOException ioe){
            System.out.println("Error while writing to file: " + ioe);
        }
    }

    private Scanner getScanner() throws IOException {
        return new Scanner(new File(filePath));
    }

}