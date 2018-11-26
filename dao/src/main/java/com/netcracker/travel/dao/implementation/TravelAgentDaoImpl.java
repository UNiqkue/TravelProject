package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

    private Connection connection;
    
    private static volatile TravelAgentDaoImpl instance;

    private TravelAgentDaoImpl(){

    }
    public static TravelAgentDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TravelAgentDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgentDaoImpl();
                }
            }
        }
        return instance;
    }




    private TravelAgent setResultTravelAgent(ResultSet resultSet) throws SQLException {
        TravelAgent travelAgent = new TravelAgent();
        travelAgent.setId(UUID.fromString(resultSet.getString("id")));
        travelAgent.setFirstName(resultSet.getString("fisrtName"));
        travelAgent.setLastName(resultSet.getString("lastName"));
        travelAgent.setUsername(resultSet.getString("username"));
        travelAgent.setPassword(resultSet.getString("password"));
        travelAgent.setEmail(resultSet.getString("email"));
        travelAgent.setActivationCode(resultSet.getString("activationCode"));
        return travelAgent;
    }

    public TravelAgent getById(UUID id) throws SQLException {
        TravelAgent travelAgent = null;
        String uuid = id.toString();

        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user WHERE uuid=?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            travelAgent = setResultTravelAgent(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return travelAgent;
    }

    /*public Collection<ravelAgent> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(travelAgent -> travelAgent.setResultTravelAgentname().equals(name))
                .collect(Collectors.toList());
    }*/

    public Collection<TravelAgent> getAll() throws SQLException {
        Collection<TravelAgent> travelAgentsList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            travelAgentsList.add(setResultTravelAgent(resultSet));
        }
        resultSet.close();
        preparedStatement.close();
        return travelAgentsList;
    }

    public TravelAgent save(TravelAgent entity) throws SQLException {
        TravelAgent travelAgent = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "INSERT INTO user(firstName, lastName, travelAgentname, password, email, activationCode)" +
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
            travelAgent = setResultTravelAgent(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
         return travelAgent;
    }

    public TravelAgent update(TravelAgent entity) throws SQLException {
        TravelAgent travelAgent = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "UPDATE travelAgent SET firstName=?, lastName=?, travelAgentname=?, password=?, email=?, activationCode=? WHERE id=?");
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
            travelAgent = setResultTravelAgent(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return travelAgent;
    }

    public void delete(UUID id) throws SQLException {

        String uuid = id.toString();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "DELETE FROM user WHERE  id=?");
        preparedStatement.setString(1, uuid);
        preparedStatement.execute();
        preparedStatement.close();
    }


    public TravelAgent getByUsername(String username) {
        return null;
    }
}
