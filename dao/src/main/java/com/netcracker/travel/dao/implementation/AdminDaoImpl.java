package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.AdminList;
import com.netcracker.travel.entity.Admin;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class AdminDaoImpl implements AbstractDao<Admin> {

    private static volatile AdminDaoImpl instance;

    private AdminDaoImpl() {
    }

    public static AdminDaoImpl getInstance() {
        if (instance == null) {
            synchronized (AdminDaoImpl.class) {
                if (instance == null) {
                    instance = new AdminDaoImpl();
                }
            }
        }
        return instance;
    }

    public Admin getById(UUID id) {
        return getAll()
                .stream()
                .filter(admin -> admin.getId().toString().equals(id.toString()))
                .findFirst().get();
    }

    public List<Admin> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(admin -> admin.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public Admin getByUsername(String username) {
        return getAll()
                .stream()
                .filter(admin -> admin.getUsername().equals(username))
                .findFirst().get();
    }

    public Admin getByEmail(String email) {
        return getAll()
                .stream()
                .filter(admin -> admin.getEmail().equals(email))
                .findFirst().get();
    }

    public Admin getByActivationCode(String activationCode) {
        return getAll()
                .stream()
                .filter(admin -> admin.getActivationCode().equals(activationCode))
                .findFirst().get();
    }

    public List<Admin> getAll() {
        AdminList adminList = new AdminList();
        return adminList.read();
    }

    public Admin save(Admin admin) {
        AdminList adminList = new AdminList();
        return adminList.write(admin);
    }

    public Admin update(Admin admin) {
        List<Admin> list = getAll();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(admin.getId().toString())) {
                System.out.println("User found");
                break;
            }
        }

        list.set(i, admin);
        try {
            AdminList adminList = new AdminList();
            adminList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
        for (i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
        return admin;
    }

    public void delete(UUID id) {
        List<Admin> list = getAll();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                System.out.println("User found");
                break;
            }
        }
        list.remove(i);
        try {
            AdminList adminList = new AdminList();
            adminList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
        for (i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }

    }






}
