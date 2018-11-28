package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.util.ClosingUtil;
import com.netcracker.travel.util.SystemLogger;
import com.netcracker.travel.util.PoolConnector;
import com.netcracker.travel.util.SqlConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;

    private static volatile CustomerDaoImpl instance;

    private CustomerDaoImpl(){
    }

    public static CustomerDaoImpl getInstance(){
        if (instance == null) {
            synchronized (AdminDaoImpl.class) {
                if (instance == null) {
                    instance = new CustomerDaoImpl();

                }
            }
        }
        return instance;
    }

    public Customer save(Customer customer) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.ADD_CUSTOMER);
            statement.setString(1, UUID.randomUUID().toString());
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
        }
        catch (SQLException e){
            String message = "Unable to add the user account ";
            e.printStackTrace();
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
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
                Customer customer = buildCustomer(result);
//                customer.setId(UUID.fromString(result.getString("id")));
//                customer.setFirstName(result.getString("firstName"));
//                customer.setLastName(result.getString("lastName"));
//                customer.setUsername(result.getString("username"));
//                customer.setPassword(result.getString("password"));
//                customer.setEmail(result.getString("email"));
//                customer.setActivationCode(result.getString("activationCode"));
//                customer.setCardNumber(result.getString("cardNumber"));
//                customer.setDateOfBirth(result.getDate("dateOfBirth"));
//                customer.setPassportInfo(result.getString("passportInfo"));
//                customer.setPhoneNumber(result.getString("phoneNumber"));
                list.add(customer);
            }
        }
        catch (SQLException e){
            String message = "Unable to return list of users ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
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
            while (result.next()) {
                customer = buildCustomer(result);
            }
        }
        catch (SQLException e){
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return customer;
    }

    public List<Customer> getByName(String lastName) {
        List<Customer> customerList = getAll()
                .stream()
                .filter(admin -> admin.getLastName().equals(lastName))
                .collect(Collectors.toList());
        return customerList;
    }

    public Customer getByUsername(String username) {
        Customer customer = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_USER_BY_USERNAME);
            statement.setString(1, username);
            result = statement.executeQuery();
            while (result.next()) {
                customer = buildCustomer(result);
            }
        }
        catch (SQLException e){
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
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
                customer = buildCustomer(result);
            }
        }
        catch (SQLException e){
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return customer;
    }

    public Customer update(Customer customer){
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_PHONE);
            statement.setString(1, customer.getPhoneNumber());
            statement.setString(2, customer.getId().toString());
            statement.executeUpdate();
        }
        catch(SQLException e){
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
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
        }
        catch (SQLException e){
            String message = "Unable to delete the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
            ClosingUtil.close(statement);
        }
    }

    private Customer buildCustomer(ResultSet result) throws SQLException{
        String uid = result.getString("id");
        String firstName = result.getString("firstName");
        String lastName = result.getString("lastName");
        String username = result.getString("username");
        String password = result.getString("password");
        String email = result.getString("email");
        String activationCode = result.getString("activationCode");
        String phoneNumber = result.getString("phoneNumber");
        String dateOfBirth = result.getString("dateOfBirth");
        String cardNumber = result.getString("cardNumber");
        String passportInfo = result.getString("passportInfo");
        Customer customer =new Customer(UUID.fromString(uid), firstName, lastName, username, password, email, activationCode, phoneNumber, Date.valueOf(dateOfBirth), cardNumber, passportInfo);
        customer.setRole(Role.valueOf(result.getString("role")));
        return customer;
    }
}
