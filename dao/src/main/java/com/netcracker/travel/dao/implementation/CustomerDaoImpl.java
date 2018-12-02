package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.CustomerList;
import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.util.ClosingUtil;
import com.netcracker.travel.util.SystemLogger;
import com.netcracker.travel.util.PoolConnector;
import com.netcracker.travel.util.SqlConfig;

<<<<<<< HEAD
import java.sql.*;
import java.util.ArrayList;
=======
import java.io.IOException;
>>>>>>> task3
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerDaoImpl implements AbstractDao<Customer> {

<<<<<<< HEAD
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;

=======
>>>>>>> task3
    private static volatile CustomerDaoImpl instance;

    private CustomerDaoImpl() {
    }

    public static CustomerDaoImpl getInstance() {
        if (instance == null) {
            synchronized (AdminDaoImpl.class) {
                if (instance == null) {
                    instance = new CustomerDaoImpl();
                }
            }
        }
        return instance;
    }

<<<<<<< HEAD
    public Customer save(Customer customer) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.ADD_CUSTOMER);
            statement.setString(1, customer.getId().toString());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getUsername());
            statement.setString(5, customer.getPassword());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getActivationCode());
            statement.setString(8, customer.getCardNumber());
            statement.setDate(9, customer.getDateOfBirth());
            statement.setString(10, customer.getPassportInfo());
            statement.setString(11, customer.getPhoneNumber());
            statement.setString(12, Role.CUSTOMER.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to add the user account ";
            e.printStackTrace();
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return customer;
    }


    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ALL_CUSTOMERS);
            result = statement.executeQuery();
            while (result.next()) {
                Customer customer = new Customer();//buildCustomer(result);
                customer.setId(UUID.fromString(result.getString("id")));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setUsername(result.getString("username"));
                customer.setPassword(result.getString("password"));
                customer.setEmail(result.getString("email"));
                customer.setActivationCode(result.getString("activation_code"));
                customer.setCardNumber(result.getString("card_number"));
                customer.setDateOfBirth(result.getDate("date_of_birth"));
                customer.setPassportInfo(result.getString("passport_info"));
                customer.setPhoneNumber(result.getString("phone_number"));
                customer.setRole(Role.valueOf(result.getString("role")));
                list.add(customer);
            }
        } catch (SQLException e) {
            String message = "Unable to return list of users ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return list;
    }

    public Customer getById(UUID id) {
        Customer customer = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_USER_BY_ID);
            statement.setString(1, id.toString());
            result = statement.executeQuery();
            if (result.next()) {
                //  customer = buildCustomer(result);
                customer = new Customer();
                customer.setId(UUID.fromString(result.getString("id")));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setUsername(result.getString("username"));
                customer.setPassword(result.getString("password"));
                customer.setEmail(result.getString("email"));
                customer.setActivationCode(result.getString("activation_code"));
                customer.setCardNumber(result.getString("card_number"));
                customer.setDateOfBirth(result.getDate("date_of_birth"));
                customer.setPassportInfo(result.getString("passport_info"));
                customer.setPhoneNumber(result.getString("phone_number"));
                customer.setRole(Role.valueOf(result.getString("role")));
            }

        } catch (SQLException e) {
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return customer;
    }

    public List<Customer> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(admin -> admin.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public Customer getByUsername(String username) {
        Customer customer = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_USER_BY_USERNAME);
            statement.setString(1, username);
            result = statement.executeQuery();
            while (result.next()) {
                customer = new Customer();
                customer.setId(UUID.fromString(result.getString("id")));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setUsername(result.getString("username"));
                customer.setPassword(result.getString("password"));
                customer.setEmail(result.getString("email"));
                customer.setActivationCode(result.getString("activation_code"));
                customer.setCardNumber(result.getString("card_number"));
                customer.setDateOfBirth(result.getDate("date_of_birth"));
                customer.setPassportInfo(result.getString("passport_info"));
                customer.setPhoneNumber(result.getString("phone_number"));
                customer.setRole(Role.valueOf(result.getString("role")));
            }
        } catch (SQLException e) {
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return customer;
    }


    public Customer getByEmail(String email) {
        Customer customer = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_USER_BY_EMAIL);
            statement.setString(1, email);
            result = statement.executeQuery();
            while (result.next()) {
                customer = new Customer();
                customer.setId(UUID.fromString(result.getString("id")));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setUsername(result.getString("username"));
                customer.setPassword(result.getString("password"));
                customer.setEmail(result.getString("email"));
                customer.setActivationCode(result.getString("activation_code"));
                customer.setCardNumber(result.getString("card_number"));
                customer.setDateOfBirth(result.getDate("date_of_birth"));
                customer.setPassportInfo(result.getString("passport_info"));
                customer.setPhoneNumber(result.getString("phone_number"));
                customer.setRole(Role.valueOf(result.getString("role")));
            }
        } catch (SQLException e) {
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return customer;
    }

    public Customer update(Customer customer) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_PHONE);
            statement.setString(1, customer.getPhoneNumber());
            statement.setString(2, customer.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return customer;
    }

    public void delete(UUID id) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.DELETE_USER_BY_ID);
            statement.setString(1, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to delete the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
    }
=======
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


>>>>>>> task3
}
