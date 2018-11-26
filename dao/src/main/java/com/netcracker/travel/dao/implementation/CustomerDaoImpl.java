package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;

import java.util.Collection;
import java.util.UUID;

public class CustomerDaoImpl implements AbstractDao<Customer> {


    @Override
    public Customer getById(UUID id) {
        return null;
    }

    @Override
    public Collection<Customer> getByName(String name) {
        return null;
    }

    @Override
    public Collection<Customer> getAll() {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
