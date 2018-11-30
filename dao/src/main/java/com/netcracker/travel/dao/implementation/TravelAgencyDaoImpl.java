package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.util.ClosingUtil;
import com.netcracker.travel.util.SystemLogger;
import com.netcracker.travel.util.PoolConnector;
import com.netcracker.travel.util.SqlConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;


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

    public TravelAgency save(TravelAgency travelAgency) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.ADD_TRAVELAGENCY);
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, travelAgency.getName());
            statement.setInt(3, travelAgency.getCountTour());
            statement.setInt(4, travelAgency.getCountTravelAgent());
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            String message = "Unable to add the user account ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
            ClosingUtil.close(statement);
        }
        return travelAgency;
    }

    @Override
    public TravelAgency update(TravelAgency travelAgency){
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_NAME);
            statement.setString(1, travelAgency.getId().toString());
            statement.executeUpdate();
        }
        catch(SQLException e){
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        }
        finally{
            ClosingUtil.close(statement);
        }
        return travelAgency;
    }

    public TravelAgency getById(UUID id) {
        TravelAgency travelAgency = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_TRAVELAGENCY_BY_ID);
            statement.setString(1, id.toString());
            result = statement.executeQuery();
            while (result.next()) {
                travelAgency = buildTravelAgency(result);
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
        return travelAgency;
    }

    public List<TravelAgency> getByName(String name) {
        List<TravelAgency> list = getAll()
                .stream()
                .filter(admin -> admin.getName().equals(name))
                .collect(Collectors.toList());
        return list;
    }


    public List<TravelAgency> getAll()  {
        List<TravelAgency> list = new ArrayList<>();
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ALL_TRAVELAGENCIES);
            result = statement.executeQuery();
            while (result.next()) {
                TravelAgency travelAgency = new TravelAgency();
                travelAgency.setId(UUID.fromString(result.getString("id")));
                travelAgency.setName(result.getString("name"));
                travelAgency.setCountTour(result.getInt("countTour"));
                travelAgency.setCountTravelAgent(result.getInt("countTravelAgent"));
                list.add(travelAgency);
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





    public void delete(UUID id) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.DELETE_TRAVELAGENCY_BY_ID);
            statement.setString(1, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to delete the account ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    private TravelAgency buildTravelAgency(ResultSet result) throws SQLException{
        String uid = result.getString("id");
        String name = result.getString("name");
        int countTour = result.getInt("countTour");
        int countTravelAgent = result.getInt("countTravelAgent");
        TravelAgency travelAgency = new TravelAgency(UUID.fromString(uid), name, countTour, countTravelAgent);
        return travelAgency;
    }

}
