package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\customer.json";

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
        Map<UUID, Customer> customerMap = new HashMap<>();
        return customerMap.get(id);
    }

    public List<Customer> getByName(String lastName) {
        Map<UUID, Customer> customerMap = new HashMap<>();
        return customerMap.values()
                .stream()
                .filter(customer -> customer.getUsername().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<Customer> getAll() {
        Map<UUID, Customer> customerMap = new HashMap<>();
        return new ArrayList<>(customerMap.values());
    }

    public Customer save(Customer customer) {
        Map<UUID, Customer> customerMap = new HashMap<>();
        if (customerMap.isEmpty()) {
            customer.setId(UUID.randomUUID());
            customerMap.put(customer.getId(), customer);
        }
        return customer;
    }

    public Customer update(Customer customer) {
        Map<UUID, Customer> customerMap = new HashMap<>();
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public void delete(UUID id) {
        Map<UUID, Customer> customerMap = new HashMap<>();
        customerMap.remove(id);
    }


    public Customer getByUsername(String username) {
        Map<UUID, Customer> customerMap = new HashMap<>();
        return (Customer) customerMap.values()
                .stream()
                .filter(customer -> customer.getUsername().equals(username));
    }
}
