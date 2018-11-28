package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;

import java.util.List;
import java.util.UUID;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private static volatile CustomerDaoImpl instance;

    private CustomerDaoImpl() {
    }

    public static CustomerDaoImpl getInstance() {
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

    public List<Customer> getByName(String lastName) {
        return null;
    }

    public List<Customer> getAll() {
        return null;
    }

    public Customer save(Customer customer) {
        return null;
    }

    public Customer update(Customer customer) {
        return customer;
    }

    public void delete(UUID id) {
    }




}
