package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private Map<UUID, Customer> customerMap = getEntityMap();

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

    public Collection<Customer> getEntityMapValues(){
        return customerMap.values();
    }

    private Map getEntityMap() {
        return AbstractDao.entityMap;
    }


    public Customer getById(UUID id) {
        return customerMap.get(id);
    }

    public Collection<Customer> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(customer -> customer.getUsername().equals(name))
                .collect(Collectors.toList());
    }

    public Collection<Customer> getAll() {
        return getEntityMapValues();
    }

    public void save(Customer customer) {
        if (customerMap.isEmpty()) {
            customer.setId(UUID.randomUUID());
            customerMap.put(customer.getId(), customer);
        }
    }

    public Customer update(Customer customer) {
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public void delete(UUID id) {
        customerMap.remove(id);
    }
}
