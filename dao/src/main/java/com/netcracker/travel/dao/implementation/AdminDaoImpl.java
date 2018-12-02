package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Admin;

import java.util.List;
import java.util.UUID;


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


}




