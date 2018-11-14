package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private Connection connection;

    private static volatile CustomerDaoImpl instance;

    private CustomerDaoImpl(Connection connection){
        this.connection = connection;
    }

    public static CustomerDaoImpl getInstance(Connection connection){
        if (instance == null) {
            synchronized (CustomerDaoImpl.class) {
                if (instance == null) {
                    instance = new CustomerDaoImpl(connection);

                }
            }
        }
        return instance;
    }

    private Customer setResultCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(UUID.fromString(resultSet.getString("id")));
        customer.setFirstName(resultSet.getString("fisrtName"));
        customer.setLastName(resultSet.getString("lastName"));
        customer.setUsername(resultSet.getString("username"));
        customer.setPassword(resultSet.getString("password"));
        customer.setEmail(resultSet.getString("email"));
        customer.setActivationCode(resultSet.getString("activationCode"));

        return customer;
    }

    public Customer getById(UUID id) throws SQLException {
        Customer customer = null;
        String uuid = id.toString();

        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user WHERE uuid=?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            customer = setResultCustomer(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return customer;
    }

    /*public Collection<Customer> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(Customer -> Customer.setResultCustomername().equals(name))
                .collect(Collectors.toList());
    }*/

    public Collection<Customer> getAll() throws SQLException {
        Collection<Customer> customersList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            customersList.add(setResultCustomer(resultSet));
        }
        resultSet.close();
        preparedStatement.close();
        return customersList;
    }

    public Customer save(Customer entity) throws SQLException {
        Customer customer = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "INSERT INTO user(firstName, lastName, username, password, email, activationCode)" +
                "VALUES(?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getUsername());
        preparedStatement.setString(4, entity.getPassword());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getActivationCode());
        preparedStatement.execute();
        preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user WHERE id=?");
        preparedStatement.setString(1, entity.getId().toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            customer = setResultCustomer(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
         return customer;
    }

    public Customer update(Customer entity) throws SQLException {
        Customer customer = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "UPDATE customer SET firstName=?, lastName=?, username=?, password=?, email=?, activationCode=? WHERE id=?");
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getUsername());
        preparedStatement.setString(4, entity.getPassword());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getActivationCode());
        preparedStatement.execute();
        preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user WHERE id=?");
        preparedStatement.setString(1, entity.getId().toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            customer = setResultCustomer(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return customer;
    }

    public void delete(UUID id) throws SQLException {
        String uuid = id.toString();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "DELETE FROM user WHERE  id=?");
        preparedStatement.setString(1, uuid);
        preparedStatement.execute();
        preparedStatement.close();
    }



}
