package com.netcracker.travel.dao.storage;

import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.enumeration.Role;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerList {

    private static String filePath = "dao\\src\\main\\resources\\storage\\customer.json";

    public List<Customer> read() {
        List<Customer> list = new ArrayList<>();

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
                customer.setRole(Role.valueOf((String) jsonObject.get("role")));
                customer.setPhoneNumber((String) jsonObject.get("phoneNumber"));
                customer.setDateOfBirth(java.sql.Date.valueOf(String.valueOf(jsonObject.get("dateOfBirth"))));
                customer.setCardNumber((String) (jsonObject.get("cardNumber")));
                customer.setPassportInfo((String) (jsonObject.get("passportInfo")));
                //     customer.setListOfTours((List<Tour>) (jsonObject.get("listOfTours")));
                list.add(customer);

            }
            scanner.close();

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf + "Unable to open file ");
        } catch (IOException e) {
            System.out.println("Error while reading to file: " + e);
        }
        return list;
    }

    public Customer write(Customer customer) {
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
                jsonUser.put("activationCode", "00000000-0000-0000-0000-000000000000");
            }
            if (customer.getRole() != null) {
                jsonUser.put("role", customer.getRole());
            } else {
                jsonUser.put("role", Role.CUSTOMER);
            }
            if (customer.getPhoneNumber() != null) {
                jsonUser.put("phoneNumber", customer.getPhoneNumber());
            } else {
                jsonUser.put("phoneNumber", "+375-00-000-00-00");
            }
            if (customer.getDateOfBirth() != null) {
                jsonUser.put("dateOfBirth", customer.getDateOfBirth());
            } else {
                jsonUser.put("dateOfBirth", "2018-10-10");
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

            jsonUser.put("listOfTours", customer.getListOfTours());

            fileWriter.write(jsonUser.toString() + "\n");
            fileWriter.flush();
            fileWriter.close();

        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf + "File not found ");
        } catch (IOException ioe) {
            System.out.println("Error while writing to file: " + ioe);
        }
        return customer;
    }

    public void clean() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }
}
