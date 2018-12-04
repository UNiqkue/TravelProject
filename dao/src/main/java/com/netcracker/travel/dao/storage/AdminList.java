package com.netcracker.travel.dao.storage;

import com.netcracker.travel.entity.Admin;
import com.netcracker.travel.entity.enumeration.Role;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AdminList {

    private static String filePath = "dao\\src\\main\\resources\\storage\\admin.json";
    private Scanner scanner;

    public List<Admin> read() {
        List<Admin> list = new ArrayList<>();
        Admin admin;
        try {
            scanner = getScanner();
            while (scanner.hasNextLine()) {
                admin = new Admin();
                JSONObject jsonObject = new JSONObject(scanner.nextLine());
                admin.setId(UUID.fromString(jsonObject.get("id").toString()));
                admin.setFirstName((String) jsonObject.get("firstName"));
                admin.setLastName((String) jsonObject.get("lastName"));
                admin.setUsername((String) jsonObject.get("username"));
                admin.setPassword((String) jsonObject.get("password"));
                admin.setEmail((String) jsonObject.get("email"));
                admin.setActivationCode((String) jsonObject.get("activationCode"));
                admin.setRole(Role.valueOf((String) jsonObject.get("role")));
                list.add(admin);
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf + "Unable to open file ");
        } catch (IOException e) {
            System.out.println("Error while reading to file: " + e);
        } finally {
            scanner.close();
        }
        return list;
    }

    public Admin write(Admin admin) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            JSONObject jsonAdmin = new JSONObject();
            try {
                if (admin.getId() != null) {
                    jsonAdmin.put("id", admin.getId());
                } else {
                    jsonAdmin.put("id", UUID.randomUUID().toString());
                }
                if (admin.getFirstName() != null) {
                    jsonAdmin.put("firstName", admin.getFirstName());
                } else {
                    jsonAdmin.put("firstName", "null");
                }
                if (admin.getLastName() != null) {
                    jsonAdmin.put("lastName", admin.getLastName());
                } else {
                    jsonAdmin.put("lastName", "null");
                }
                if (admin.getUsername() != null) {
                    jsonAdmin.put("username", admin.getUsername());
                } else {
                    jsonAdmin.put("username", "null");
                }
                if (admin.getPassword() != null) {
                    jsonAdmin.put("password", admin.getPassword());
                } else {
                    jsonAdmin.put("password", "null");
                }
                if (admin.getEmail() != null) {
                    jsonAdmin.put("email", admin.getEmail());
                } else {
                    jsonAdmin.put("email", "null");
                }
                if (admin.getActivationCode() != null) {
                    jsonAdmin.put("activationCode", admin.getActivationCode());
                } else {
                    jsonAdmin.put("activationCode", "null");
                }
                if (admin.getRole() != null) {
                    jsonAdmin.put("role", admin.getRole());
                } else {
                    jsonAdmin.put("role", Role.ADMIN);
                }
                fileWriter.write(jsonAdmin.toString() + "\n");
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
        return admin;
    }

    private Scanner getScanner() throws IOException {
        return new Scanner(new File(filePath));
    }

    public void clean() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
        }
    }

}
