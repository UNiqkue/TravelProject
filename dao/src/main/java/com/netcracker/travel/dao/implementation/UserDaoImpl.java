package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;
import org.json.JSONObject;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class UserDaoImpl implements AbstractDao<User> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\user.txt";

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

    public void writeEntity(User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            jsonObject.put("id", user.getId());
            jsonObject.put("firstName", user.getFirstName());
            jsonObject.put("lastName", user.getLastName());
            jsonObject.put("username", user.getUsername());
            jsonObject.put("password", user.getPassword());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("activationCode", user.getActivationCode());
            jsonObject.put("role", user.getRole());
            bw.write(jsonObject.toString());
            bw.newLine();
            bw.close();

            System.out.println("done writing to file " + filePath);

        }
        catch(FileNotFoundException fnf)
        {
            System.out.println(fnf + "File not found ");
        }
        catch(IOException ioe)
        {
            System.out.println("Error while writing to file: " + ioe);
        }
    }

    public List<User> readEntity() {
        List<User> entityList = new ArrayList<>();
        User user = new User();
        try {
            System.out.println("read file: " + filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = bufferedReader.readLine();
            StringBuilder fileBuffer = new StringBuilder();
            while (isLineValid(line) != false) {
                JSONObject jsonObject = new JSONObject(line);
                user.setId(UUID.fromString(jsonObject.get("id").toString()));
                user.setFirstName((String) jsonObject.get("firstName"));
                user.setLastName((String) jsonObject.get("lastName"));
                user.setUsername((String) jsonObject.get("username"));
                user.setPassword((String) jsonObject.get("password"));
                user.setEmail((String) jsonObject.get("email"));
                user.setActivationCode((String) jsonObject.get("activationCode"));
                entityList.add(user);
                return entityList;
            }
           /* FileInputStream fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            InputStreamReader isr = new InputStreamReader(bis);
            Scanner scanner = new Scanner(isr);
            String json = "";
            while (scanner.hasNextLine()) {
                json = scanner.nextLine();
                JSONObject jsonObject = new JSONObject(json);
                user.setId(UUID.fromString(jsonObject.get("id").toString()));
                user.setFirstName((String) jsonObject.get("firstName"));
                user.setLastName((String) jsonObject.get("lastName"));
                user.setUsername((String) jsonObject.get("username"));
                user.setPassword((String) jsonObject.get("password"));
                user.setEmail((String) jsonObject.get("email"));
                user.setActivationCode((String) jsonObject.get("activationCode"));
              //  user.setRole((Set<Role>) jsonObject.get("role"));
                entityList.add(user);

              //  scanner.close();
            }*/

            System.out.println("file read ok! Has " + entityList.size() + " entities");
        } catch(FileNotFoundException fnf){
                System.out.println(fnf + "Unable to open file ");
        } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
        }

        return entityList;

    }

    public boolean isLineValid(String line){
        if (line == null || line.isEmpty()){
            return false;
        } else return true;
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
        return readEntity();
        //return new ArrayList<>(userMap.values());
    }

    public User save(User user) {
        Map<UUID, User> userMap = new HashMap<>();
        if(userMap.isEmpty()){
            user.setId(UUID.randomUUID());
            userMap.put(user.getId(), user);
        }
        writeEntity(user);
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
        userDao.save(user);
        System.out.println(userDao.getAll());
        while (true){

        }
    }

}
