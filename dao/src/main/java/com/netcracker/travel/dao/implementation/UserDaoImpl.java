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

/* public void writeEntity(User user) {
            JSONObject jsonObject = new JSONObject();
            JSONObject jsonSlave = new JSONObject();
            try {
                FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                List<String> idList = new ArrayList<>();
                // if(jsonObject.length() == 0){
                // idList.add(user.getId().toString());
                jsonSlave.put("id", idList);

                if(user.getFirstName()!=null) {
                jsonObject.put("firstName", user.getFirstName());
                } else {
                jsonObject.put("firstName", "null");
                }
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
/ /
    public String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
        }

        public List<User> readEntity() {
            List<User> entityList = new ArrayList<>();
            User user = new User();
            try {
                System.out.println("read file: " + filePath);
            JSONObject jsonObject = new JSONObject(readFile(filePath, Charset.defaultCharset()));
            JSONArray jsonArrayId = jsonObject.getJSONArray("id");
            JSONArray jsonArrayFirstName = jsonObject.getJSONArray("firstName");
            JSONArray jsonArrayLastName = jsonObject.getJSONArray("lastName");
            JSONArray jsonArrayUsername = jsonObject.getJSONArray("username");
            JSONArray jsonArrayPassword = jsonObject.getJSONArray("password");
            JSONArray jsonArrayEmail = jsonObject.getJSONArray("email");
            JSONArray jsonArrayActivationCode = jsonObject.getJSONArray("activationCode");

            for (int i = 0; i < jsonArrayId.length(); i++){
            user.setId(UUID.fromString(jsonArrayId.getJSONObject(i).getString("id")));
            user.setFirstName(jsonArrayFirstName.getJSONObject(i).getString("firstName"));
            user.setLastName(jsonArrayLastName.getJSONObject(i).getString("lastName"));
            user.setUsername(jsonArrayUsername.getJSONObject(i).getString("username"));
            user.setPassword(jsonArrayPassword.getJSONObject(i).getString("password"));
            user.setEmail(jsonArrayEmail.getJSONObject(i).getString("email"));
            user.setActivationCode(jsonArrayActivationCode.getJSONObject(i).getString("activationCode"));

            entityList.add(user);
            System.out.println("User " + i + " info: " + user.toString());
            }
            */

            /* user.setId(UUID.fromString(jsonObject.get("id").toString()));
            user.setFirstName((String) jsonObject.get("firstName"));
            user.setLastName((String) jsonObject.get("lastName"));
            user.setUsername((String) jsonObject.get("username"));
            user.setPassword((String) jsonObject.get("password"));
            user.setEmail((String) jsonObject.get("email"));
            user.setActivationCode((String) jsonObject.get("activationCode"));*/

            /* System.out.println("file read ok! Has " + entityList.size() + " entities");
            } catch(FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
            } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
            }
            return entityList;
            } */


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
        User user = new User();
        try {
            Scanner scanner = getScanner();
            while (scanner.hasNextLine()) {
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