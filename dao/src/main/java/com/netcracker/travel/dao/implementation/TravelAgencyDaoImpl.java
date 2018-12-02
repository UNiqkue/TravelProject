package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.TravelAgencyList;
import com.netcracker.travel.entity.TravelAgency;
import com.netcracker.travel.util.ClosingUtil;
import com.netcracker.travel.util.SystemLogger;
import com.netcracker.travel.util.PoolConnector;
import com.netcracker.travel.util.SqlConfig;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
=======
import java.io.IOException;
>>>>>>> task3
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TravelAgencyDaoImpl implements AbstractDao<TravelAgency> {

<<<<<<< HEAD
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;


    private static volatile TravelAgencyDaoImpl instance;

=======
    private static volatile TravelAgencyDaoImpl instance;

>>>>>>> task3
    private TravelAgencyDaoImpl() {
    }

    public static TravelAgencyDaoImpl getInstance() {
        if (instance == null) {
            synchronized (TravelAgencyDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgencyDaoImpl();
                }
            }
        }
        return instance;
    }

<<<<<<< HEAD
    public TravelAgency save(TravelAgency travelAgency) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.ADD_TRAVELAGENCY);
            statement.setString(1, travelAgency.getId().toString());
            statement.setString(2, travelAgency.getName());
            statement.setInt(3, travelAgency.getCountTour());
            statement.setInt(4, travelAgency.getCountTravelAgent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            String message = "Unable to add the user account ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return travelAgency;
    }

    @Override
    public TravelAgency update(TravelAgency travelAgency) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_NAME);
            statement.setString(1, travelAgency.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
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
                travelAgency = new TravelAgency();
                travelAgency.setId(UUID.fromString(result.getString("id")));
                travelAgency.setName(result.getString("name"));
                travelAgency.setCountTour(result.getInt("count_tour"));
                travelAgency.setCountTravelAgent(result.getInt("count_travel_agent"));
            }
        } catch (SQLException e) {
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return travelAgency;
    }

    public List<TravelAgency> getByName(String name) {
        List<TravelAgency> list = getAll()
                .stream()
                .filter(agency -> agency.getName().equals(name))
                .collect(Collectors.toList());
        return list;
    }


    public List<TravelAgency> getAll() {
        List<TravelAgency> list = new ArrayList<>();
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ALL_TRAVELAGENCIES);
            result = statement.executeQuery();
            while (result.next()) {
                TravelAgency travelAgency = new TravelAgency();
                travelAgency.setId(UUID.fromString(result.getString("id")));
                travelAgency.setName(result.getString("name"));
                travelAgency.setCountTour(result.getInt("count_tour"));
                travelAgency.setCountTravelAgent(result.getInt("count_travel_agents"));
                list.add(travelAgency);
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

  /*  private TravelAgency buildTravelAgency(ResultSet result) throws SQLException {
        String uid = result.getString("id");
        String name = result.getString("name");
        int countTour = result.getInt("count_tour");
        int countTravelAgent = result.getInt("count_travel_agent");
        TravelAgency travelAgency = new TravelAgency(UUID.fromString(uid), name, countTour, countTravelAgent);
        return travelAgency;
    }*/

=======
    public TravelAgency getById(UUID id) {
        return getAll()
                .stream()
                .filter(travelAgency -> travelAgency.getId().toString().equals(id.toString()))
                .findFirst().get();
    }

    public List<TravelAgency> getByName(String name) {
        return getAll()
                .stream()
                .filter(travelAgency -> travelAgency.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<TravelAgency> getAll() {
        TravelAgencyList list = new TravelAgencyList();
        return list.read();
    }

    public TravelAgency save(TravelAgency travelAgency) {
        TravelAgencyList list = new TravelAgencyList();
        return list.write(travelAgency);
    }

    public TravelAgency update(TravelAgency travelAgency) {
        removeById(travelAgency.getId());
        return save(travelAgency);
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public TravelAgency removeById(UUID id) {
        List<TravelAgency> list = getAll();
        TravelAgency travelAgency = new TravelAgency();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                travelAgency = list.remove(i);
                System.out.println("TravelAgency found");
                break;
            }
        }
        saveList(list);
        return travelAgency;
    }

    private void saveList(List<TravelAgency> list) {
        clean();
        for (int i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    private void clean() {
        TravelAgencyList travelAgencyList = new TravelAgencyList();
        try {
            travelAgencyList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
        }
    }


>>>>>>> task3
}
