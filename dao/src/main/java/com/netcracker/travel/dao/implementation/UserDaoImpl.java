package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserDaoImpl implements AbstractDao<User> {

    private Connection connection;

    private static volatile UserDaoImpl instance;

    private UserDaoImpl(Connection connection){
        this.connection = connection;
    }

    public static UserDaoImpl getInstance(Connection connection){
        if (instance == null) {
            synchronized (UserDaoImpl.class) {
                if (instance == null) {
                    instance = new UserDaoImpl(connection);
                }
            }
        }
        return instance;
    }


    private User setResultUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(UUID.fromString(resultSet.getString("id")));
        user.setFirstName(resultSet.getString("fisrtName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setActivationCode(resultSet.getString("activationCode"));
        return user;
    }

    public User getById(UUID id) throws SQLException {
        User user = null;
        String uuid = id.toString();

        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user WHERE uuid=?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = setResultUser(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    /*public Collection<User> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(user -> user.getUsername().equals(name))
                .collect(Collectors.toList());
    }*/

    public List<User> getAll() throws SQLException {
        List<User> usersList = new ArrayList<>();
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

    public User save(User entity) throws SQLException {
        User user = null;
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
            user = setResultUser(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    public User update(User entity) throws SQLException {
        User user = null;
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
            user = setResultUser(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
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
