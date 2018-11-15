package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

    private Connection connection;

    private static volatile TravelAgencyDaoImpl instance;

    private TravelAgencyDaoImpl(){

    }

    public static TravelAgencyDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TravelAgencyDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgencyDaoImpl();
                }
            }
        }
        return instance;
    }

    private TravelAgency setResultTravelAgency(ResultSet resultSet) throws SQLException {
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setId(UUID.fromString(resultSet.getString("id")));
        travelAgency.setName(resultSet.getString("name"));
        travelAgency.setCountTour(Integer.valueOf(resultSet.getString("countTour")));
        travelAgency.setCountTravelAgent(Integer.valueOf(resultSet.getString("countTravelAgents")));

        return travelAgency;
    }

    public TravelAgency getById(UUID id) throws SQLException {
        TravelAgency travelAgency = null;
        String uuid = id.toString();

        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM travelagency WHERE uuid=?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            travelAgency = setResultTravelAgency(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return travelAgency;
    }

    /*public Collection<travelAgency> getByName(String name) {
        return getEntityMapValues()
                .stream()
                .filter(travelAgency -> travelAgency.setResultTravelAgencyname().equals(name))
                .collect(Collectors.toList());
    }*/

    public Collection<TravelAgency> getAll() throws SQLException {
        Collection<TravelAgency> travelAgenciesList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM travelagency");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            travelAgenciesList.add(setResultTravelAgency(resultSet));
        }
        resultSet.close();
        preparedStatement.close();
        return travelAgenciesList;
    }

    public TravelAgency save(TravelAgency entity) throws SQLException {
        TravelAgency travelAgency = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "INSERT INTO travelAgency(name, countTour, countTravelAgents)" +
                "VALUES(?, ?, ?)");
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getCountTour());
        preparedStatement.setInt(3, entity.getCountTravelAgent());

        preparedStatement.execute();
        preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM travelagency WHERE id=?");
        preparedStatement.setString(1, entity.getId().toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            travelAgency = setResultTravelAgency(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
         return travelAgency;
    }

    public TravelAgency update(TravelAgency entity) throws SQLException {
        TravelAgency travelAgency = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "UPDATE travelAgency SET name=?, countTour=?, countTravelAgents=? WHERE id=?");
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getCountTour());
        preparedStatement.setInt(3, entity.getCountTravelAgent());
        preparedStatement.execute();
        preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM travelagency WHERE id=?");
        preparedStatement.setString(1, entity.getId().toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            travelAgency = setResultTravelAgency(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return travelAgency;
    }

    public void delete(UUID id) throws SQLException {

        String uuid = id.toString();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "DELETE FROM travelagency WHERE  id=?");
        preparedStatement.setString(1, uuid);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
