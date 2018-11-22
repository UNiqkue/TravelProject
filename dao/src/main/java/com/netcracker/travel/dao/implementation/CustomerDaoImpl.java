package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.AdminList;
import com.netcracker.travel.dao.storage.CustomerList;
import com.netcracker.travel.entity.Customer;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return getAll()
                .stream()
                .filter(customer -> customer.getId().toString().equals(id.toString()))
                .findFirst().get();
    }

    public List<Customer> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(customer -> customer.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public Customer getByUsername(String username) {
        return getAll()
                .stream()
                .filter(customer -> customer.getUsername().equals(username))
                .findFirst().get();
    }

    public Customer getByEmail(String email) {
        return getAll()
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst().get();
    }

    public Customer getByActivationCode(String activationCode) {
        return getAll()
                .stream()
                .filter(customer -> customer.getActivationCode().equals(activationCode))
                .findFirst().get();
    }

    public List<Customer> getAll() {
        CustomerList customerList = new CustomerList();
        return customerList.read();
    }

    public Customer save(Customer customer) {
        CustomerList customerList = new CustomerList();
        return customerList.write(customer);
    }

    public Customer update(Customer customer) {
        removeById(customer.getId());
        try {
            AdminList adminList = new AdminList();
            adminList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
        return save(customer);
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public Customer removeById(UUID id) {
        List<Customer> list = getAll();
        Customer customer = new Customer();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                customer = list.remove(i);
                System.out.println("Customer found");
                break;
            }
        }
        saveList(list);
        return customer;
    }

    private void saveList(List<Customer> list) {
        clean();
        for (int i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    private void clean() {
        CustomerList customerList = new CustomerList();
        try {
            customerList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
    }


}
