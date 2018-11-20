package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
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
        return getAll()
                .stream()
                .filter(user -> user.getId().toString().equals(id.toString()))
                .collect(Collectors.toList()).get(0);
    }

    public List<User> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(user -> user.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public User getByUsername(String username) {
        return getAll()
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .collect(Collectors.toList()).get(0);
    }

    public User getByEmail(String email) {
        return getAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList()).get(0);
    }

    public User getByActivationCode(String activationCode){
        return getAll()
                .stream()
                .filter(user -> user.getActivationCode().equals(activationCode))
                .collect(Collectors.toList()).get(0);
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        User user;
        try {
            Scanner scanner = getScanner();
            while (scanner.hasNextLine()) {
                user = new User();
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

    public User save(User user) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonUser = new JSONObject();

                if (user.getId() != null) {
                    jsonUser.put("id", user.getId());
                } else {
                    jsonUser.put("id", UUID.randomUUID().toString());
                }
                if (user.getFirstName() != null) {
                    jsonUser.put("firstName", user.getFirstName());
                } else {
                    jsonUser.put("firstName", "null");
                }
                if (user.getLastName() != null) {
                    jsonUser.put("lastName", user.getLastName());
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
        return user;
    }

    public User update(User user) {
        List<User> list = getAll();
        int i;
        for(i=0; i<=list.size()-1; i++){
            if(list.get(i).getId().toString().equals(user.getId().toString())){
                System.out.println("User found");
                break;
            }
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("Choose the action: \n 1. Change firstName \n 2. Change lastName \n 3. Change username \n 4. Change password \n 5. Change email \n 0. Exit");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                user = list.get(i);
                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        System.out.println("Input firstName");

                        user.setFirstName(reader.readLine());
                        list.set(i, user);
                        break;
                    case 2:
                        System.out.println("Input lastName");
                        user.setLastName(reader.readLine());
                        list.set(i, user);
                        break;
                    case 3:
                        System.out.println("Input username");
                        user.setUsername(reader.readLine());
                        list.set(i, user);
                        break;
                    case 4:
                        System.out.println("Input password");
                        user.setPassword(reader.readLine());
                        list.set(i, user);
                        break;
                    case 5:
                        System.out.println("Input email");
                        user.setEmail(reader.readLine());
                        list.set(i, user);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Input 1, 2 or 3 - action and 0 - exit");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        try {
            clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
        for(i=0; i<=list.size()-1; i++){
            save(list.get(i));
        }
        return user;
    }

    public void delete(UUID id) {
        List<User> list = getAll();
        int i;
        for(i=0; i<=list.size()-1; i++){
            if(list.get(i).getId().toString().equals(id.toString())){
                System.out.println("User found");
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

    private Scanner getScanner() throws IOException {
        return new Scanner(new File(filePath));
    }

    private void clean() throws IOException{
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }

}

/*{"firstName":"AAAAAAAA","lastName":"a1","password":"emdlsa","role":[],"id":"f630bcf5-c6ad-441c-9a52-0869ecc4f232","activationCode":"11111","email":"jack1@gmail.com","username":"KJNkjd"}
{"firstName":"BBBBBB","lastName":"b2","password":"null2222","role":[],"id":"a49f5472-8fc8-487b-b9d5-5bfd4fab0a5a","activationCode":"22222","email":"mike2@gmail.com","username":"mike2"}
{"firstName":"CCCCCCC","lastName":"c3","password":"null3333","role":[],"id":"ea2b18d9-cbb7-4a00-b835-8f3c39a6022e","activationCode":"33333","email":"ukky3@gmail.com","username":"ukky3"}
{"firstName":"DDDDDDDD","lastName":"d4","password":"null4444","role":[],"id":"bce09a31-351a-4a1f-a48e-684fe30e96a6","activationCode":"44444","email":"socrat4@gmail.com","username":"socrat4"}
{"firstName":"FFFFFFFFF","lastName":"f5","password":"null5555","role":[],"id":"e9da3d2e-5536-4765-9ad4-bd6dc5968337","activationCode":"55555","email":"ivan5@mail.ru","username":"ivan5"}
{"firstName":"EEEEEEEEEE","lastName":"e6","password":"null","role":[],"id":"02a89eee-6282-4f29-9012-2027b832cd7e","activationCode":"null","email":"null","username":"null"}

 */