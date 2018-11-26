package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AdminDaoImpl implements AbstractDao<Admin> {

    private Connection connection;

    private static volatile AdminDaoImpl instance;

    private AdminDaoImpl(){

    }

    public static AdminDaoImpl getInstance(){
        if (instance == null) {
            synchronized (AdminDaoImpl.class) {
                if (instance == null) {
                    instance = new AdminDaoImpl();
                }
            }
        }
        return instance;
    }


    private Admin setResultUser(ResultSet resultSet) throws SQLException {
        Admin admin = new Admin();
        admin.setId(UUID.fromString(resultSet.getString("id")));
        admin.setFirstName(resultSet.getString("fisrtName"));
        admin.setLastName(resultSet.getString("lastName"));
        admin.setUsername(resultSet.getString("username"));
        admin.setPassword(resultSet.getString("password"));
        admin.setEmail(resultSet.getString("email"));
        admin.setActivationCode(resultSet.getString("activationCode"));
        return admin;
    }

    public Admin getById(UUID id) throws SQLException {
        Admin admin = null;
        String uuid = id.toString();

        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user WHERE uuid=?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            admin = setResultUser(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return admin;
    }

    /*public Collection<User> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(user -> user.getUsername().equals(name))
                .collect(Collectors.toList());
    }*/

    public List<Admin> getAll() throws SQLException {
        List<Admin> usersList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            usersList.add(setResultUser(resultSet));
        }
        resultSet.close();
        preparedStatement.close();
        return usersList;
    }

    public Admin save(Admin entity) throws SQLException {
        Admin admin = null;
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
            admin = setResultUser(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return admin;
    }

    public Admin update(Admin entity) throws SQLException {
        Admin admin = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "UPDATE user SET firstName=?, lastName=?, username=?, password=?, email=?, activationCode=? WHERE id=?");
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
            admin = setResultUser(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return admin;
    }

    public void delete(UUID id) throws SQLException {
        String uuid = id.toString();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "DELETE FROM user WHERE  id=?");
        preparedStatement.setString(1, uuid);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public Admin getByUsername(String username){
        return null;
    }

}
