package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.Tour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private Map<Integer, Tour> customers = new HashMap<>();

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
        return null;
    }

    public Customer getByName(String name) {
        return null;
    }

    public List<Customer> getAll() {
        return null;
    }

    public Customer save(Customer customer) {
        return null;
    }

    public void update(Customer customer) {
    }

    public void delete(UUID id) {
    }
}
