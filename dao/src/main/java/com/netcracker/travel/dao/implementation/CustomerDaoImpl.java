package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Address;
import com.netcracker.travel.entity.Customer;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\customer.json";

    private static volatile CustomerDaoImpl instance;

    private CustomerDaoImpl(){}

    public static CustomerDaoImpl getInstance(){
        if (instance == null) {
            synchronized (CustomerDaoImpl.class) {
                if (instance == null) {
                    instance = new CustomerDaoImpl();
                }
            }
        }
        return instance;
    }

    public Customer getById(UUID id) {
        return getAll()
                .stream()
                .filter(customer -> customer.getId().toString().equals(id.toString()))
                .collect(Collectors.toList()).get(0);
    }

    public List<Customer> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(customer -> customer.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public Customer getByUsername(String username) {
        return getAll()
                .stream()
                .filter(customer -> customer.getUsername().equals(username))
                .collect(Collectors.toList()).get(0);
    }

    public Customer getByEmail(String email) {
        return getAll()
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .collect(Collectors.toList()).get(0);
    }

    public Customer getByActivationCode(String activationCode){
        return getAll()
                .stream()
                .filter(customer -> customer.getActivationCode().equals(activationCode))
                .collect(Collectors.toList()).get(0);
    }

    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<Customer>();
        Customer customer;
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                customer = new Customer();
                JSONObject jsonObject = new JSONObject(scanner.nextLine());

                customer.setId(UUID.fromString(jsonObject.get("id").toString()));
                customer.setFirstName((String) jsonObject.get("firstName"));
                customer.setLastName((String) jsonObject.get("lastName"));
                customer.setUsername((String) jsonObject.get("username"));
                customer.setPassword((String) jsonObject.get("password"));
                customer.setEmail((String) jsonObject.get("email"));
                customer.setActivationCode((String) jsonObject.get("activationCode"));
                customer.setPhoneNumber((String) jsonObject.get("phoneNumber"));
                customer.setDateOfBirth(java.sql.Date.valueOf(String.valueOf(jsonObject.get("dateOfBirth"))));
                customer.setCardNumber((String) (jsonObject.get("cardNumber")));
                customer.setPassportInfo((String) (jsonObject.get("passportInfo")));
                customer.setAddress((Address) (jsonObject.get("address")));
             //   customer.setListOfTours((List<Tour>) (jsonObject.get("listOfTours")));
                list.add(customer);

            }
            scanner.close();

        } catch(FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
        } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
        }
        return list;
    }

    public Customer save(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonUser = new JSONObject();

            if (customer.getId() != null) {
                jsonUser.put("id", customer.getId());
            } else {
                jsonUser.put("id", UUID.randomUUID().toString());
            }
            if (customer.getFirstName() != null) {
                jsonUser.put("firstName", customer.getFirstName());
            } else {
                jsonUser.put("firstName", "null");
            }
            if (customer.getLastName() != null) {
                jsonUser.put("lastName", customer.getLastName());
            } else {
                jsonUser.put("lastName", "null");
            }
            if (customer.getUsername() != null) {
                jsonUser.put("username", customer.getUsername());
            } else {
                jsonUser.put("username", "null");
            }
            if (customer.getPassword() != null) {
                jsonUser.put("password", customer.getPassword());
            } else {
                jsonUser.put("password", "null");
            }
            if (customer.getEmail() != null) {
                jsonUser.put("email", customer.getEmail());
            } else {
                jsonUser.put("email", "null");
            }
            if (customer.getActivationCode() != null) {
                jsonUser.put("activationCode", customer.getActivationCode());
            } else {
                jsonUser.put("activationCode", "null");
            }
            jsonUser.put("role", customer.getRole());

            if (customer.getPhoneNumber() != null) {
                jsonUser.put("phoneNumber", customer.getPhoneNumber());
            } else {
                jsonUser.put("phoneNumber", "null");
            }
            if (customer.getDateOfBirth() != null) {
                jsonUser.put("dateOfBirth", customer.getDateOfBirth());
            } else {
                jsonUser.put("dateOfBirth", "null");
            }
            if (customer.getCardNumber() != null) {
                jsonUser.put("cardNumber", customer.getCardNumber());
            } else {
                jsonUser.put("cardNumber", "null");
            }
            if (customer.getPassportInfo() != null) {
                jsonUser.put("passportInfo", customer.getPassportInfo());
            } else {
                jsonUser.put("passportInfo", "null");
            }
            if (customer.getAddress() != null) {
                jsonUser.put("address", customer.getAddress());
            } else {
                jsonUser.put("address", "null");
            }

            jsonUser.put("listOfTours", customer.getListOfTours());

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
        return customer;
    }

    public Customer update(Customer customer) {
        ///

        return customer;
    }

    public void delete(UUID id) {
        List<Customer> list = getAll();
        int i;
        for(i=0; i<=list.size()-1; i++){
            if(list.get(i).getId().toString().equals(id.toString())){
                System.out.println("Customer found");
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
