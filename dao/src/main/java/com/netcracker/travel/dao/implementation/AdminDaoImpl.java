package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
<<<<<<< HEAD
import com.netcracker.travel.dao.storage.AdminList;
import com.netcracker.travel.entity.Admin;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
=======
import com.netcracker.travel.entity.Admin;

import java.util.List;
import java.util.UUID;
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded


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
<<<<<<< HEAD
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

    public List<Admin> getAll() {
        AdminList adminList = new AdminList();
        return adminList.read();
    }

    public Admin save(Admin admin) {
        AdminList adminList = new AdminList();
        return adminList.write(admin);
    }

    public Admin update(Admin admin) {
        removeById(admin.getId());
        return save(admin);
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public Admin removeById(UUID id) {
        List<Admin> list = getAll();
        Admin admin = new Admin();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                admin = list.remove(i);
                System.out.println("Admin found");
                break;
            }
        }
        saveList(list);
        return admin;
    }

    private void saveList(List<Admin> list) {
        clean();
        for (int i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    private void clean() {
        AdminList adminList = new AdminList();
        try {
            adminList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
    }
=======
        return null;
    }

    public List<Admin> getByName(String lastName) {
        return null;
    }

    public List<Admin> getAll() {
        return null;
    }

    public Admin save(Admin admin) {
        return admin;
    }

    public Admin update(Admin admin) {
        return admin;
    }

    public void delete(UUID id) {
    }

>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded

}




