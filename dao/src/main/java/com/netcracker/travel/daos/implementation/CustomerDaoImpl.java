package com.netcracker.travel.daos.implementation;

import com.netcracker.travel.daos.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerDaoImpl<T> implements AbstractDao<Customer> {

    private List<Customer> customers = new ArrayList<>();

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
