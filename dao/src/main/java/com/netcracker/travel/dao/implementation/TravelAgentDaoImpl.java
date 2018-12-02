package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.dao.storage.TravelAgentList;
import com.netcracker.travel.entity.TravelAgent;
import com.netcracker.travel.entity.enumeration.Role;
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

public class TravelAgentDaoImpl implements AbstractDao<TravelAgent> {

<<<<<<< HEAD
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;

    private static volatile TravelAgentDaoImpl instance;

    private TravelAgentDaoImpl() {

=======
    private static volatile TravelAgentDaoImpl instance;

    private TravelAgentDaoImpl() {
>>>>>>> task3
    }

    public static TravelAgentDaoImpl getInstance() {
        if (instance == null) {
            synchronized (TravelAgentDaoImpl.class) {
                if (instance == null) {
                    instance = new TravelAgentDaoImpl();
                }
            }
        }
        return instance;
    }

<<<<<<< HEAD
    public TravelAgent save(TravelAgent travelAgent) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.ADD_TRAVELAGENT);
            statement.setString(1, travelAgent.getId().toString());
            statement.setString(2, travelAgent.getFirstName());
            statement.setString(3, travelAgent.getLastName());
            statement.setString(4, travelAgent.getUsername());
            statement.setString(5, travelAgent.getPassword());
            statement.setString(6, travelAgent.getEmail());
            statement.setString(7, travelAgent.getActivationCode());
            statement.setString(8, travelAgent.getPhoneNumber());
            statement.setString(9, travelAgent.getPosition());
            statement.setString(10, travelAgent.getTravelAgencyId().toString());
            statement.setString(11, Role.TRAVELAGENT.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            String message = "Unable to add the user account ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return travelAgent;
    }

    public List<TravelAgent> getAll() {
        List<TravelAgent> list = new ArrayList<>();
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ALL_TRAVELAGENTS);
            result = statement.executeQuery();
            while (result.next()) {
                TravelAgent travelAgent = new TravelAgent();//buildTravelAgent(result);
                travelAgent.setId(UUID.fromString(result.getString("id")));
                travelAgent.setFirstName(result.getString("first_name"));
                travelAgent.setLastName(result.getString("last_name"));
                travelAgent.setUsername(result.getString("username"));
                travelAgent.setPassword(result.getString("password"));
                travelAgent.setEmail(result.getString("email"));
                travelAgent.setActivationCode(result.getString("activation_code"));
                travelAgent.setPhoneNumber(result.getString("phone_number"));
                travelAgent.setPosition(result.getString("position"));
                travelAgent.setTravelAgencyId(UUID.fromString(result.getString("travel_agency_id")));
                travelAgent.setRole(Role.valueOf(result.getString("role")));
                list.add(travelAgent);
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

    public TravelAgent getById(UUID id) {
        TravelAgent travelAgent = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_TRAVELAGENT_BY_ID);
            statement.setString(1, id.toString());
            result = statement.executeQuery();
            while (result.next()) {
                travelAgent = new TravelAgent();//buildTravelAgent(result);
                travelAgent.setId(UUID.fromString(result.getString("id")));
                travelAgent.setFirstName(result.getString("first_name"));
                travelAgent.setLastName(result.getString("last_name"));
                travelAgent.setUsername(result.getString("username"));
                travelAgent.setPassword(result.getString("password"));
                travelAgent.setEmail(result.getString("email"));
                travelAgent.setActivationCode(result.getString("activation_code"));
                travelAgent.setPhoneNumber(result.getString("phone_number"));
                travelAgent.setPosition(result.getString("position"));
                travelAgent.setTravelAgencyId(UUID.fromString(result.getString("travel_agency_id")));
                travelAgent.setRole(Role.valueOf(result.getString("role")));
            }
        } catch (SQLException e) {
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return travelAgent;
    }

    public List<TravelAgent> getByName(String lastName) {
        List<TravelAgent> list = getAll()
                .stream()
                .filter(admin -> admin.getLastName().equals(lastName))
                .collect(Collectors.toList());
        return list;
    }

    public TravelAgent getByUsername(String username) {
        TravelAgent travelAgent = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_TRAVELAGENT_BY_USERNAME);
            statement.setString(1, username);
            result = statement.executeQuery();
            while (result.next()) {
                travelAgent = new TravelAgent();
                travelAgent.setId(UUID.fromString(result.getString("id")));
                travelAgent.setFirstName(result.getString("first_name"));
                travelAgent.setLastName(result.getString("last_name"));
                travelAgent.setUsername(result.getString("username"));
                travelAgent.setPassword(result.getString("password"));
                travelAgent.setEmail(result.getString("email"));
                travelAgent.setActivationCode(result.getString("activation_code"));
                travelAgent.setPhoneNumber(result.getString("phone_number"));
                travelAgent.setPosition(result.getString("position"));
                travelAgent.setTravelAgencyId(UUID.fromString(result.getString("travel_agency_id")));
                travelAgent.setRole(Role.valueOf(result.getString("role")));
            }
        } catch (SQLException e) {
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return travelAgent;
    }

    public TravelAgent update(TravelAgent travelAgent) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_POSITION);
            statement.setString(1, travelAgent.getPhoneNumber());
            statement.setString(2, travelAgent.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return travelAgent;
    }

    public void delete(UUID id) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.DELETE_TRAVELAGENT_BY_ID);
            statement.setString(1, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to delete the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
=======
    public TravelAgent getById(UUID id) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getId().toString().equals(id.toString()))
                .findFirst().get();
    }

    public List<TravelAgent> getByName(String lastName) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public TravelAgent getByUsername(String username) {
        return getAll()
                .stream()
                .filter(travelAgent -> travelAgent.getUsername().equals(username))
                .findFirst().get();
    }

    public List<TravelAgent> getAll() {
        TravelAgentList list = new TravelAgentList();
        return list.read();
    }

    public TravelAgent save(TravelAgent travelAgent) {
        TravelAgentList list = new TravelAgentList();
        return list.write(travelAgent);
    }

    public TravelAgent update(TravelAgent travelAgent) {
        removeById(travelAgent.getId());
        return save(travelAgent);
    }

    public void delete(UUID id) {
        removeById(id);
    }

    public TravelAgent removeById(UUID id) {
        List<TravelAgent> list = getAll();
        TravelAgent travelAgent = new TravelAgent();
        int i;
        for (i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).getId().toString().equals(id.toString())) {
                travelAgent = list.remove(i);
                System.out.println("TravelAgent found");
                break;
            }
        }
        saveList(list);
        return travelAgent;
    }

    private void saveList(List<TravelAgent> list) {
        clean();
        for (int i = 0; i <= list.size() - 1; i++) {
            save(list.get(i));
        }
    }

    private void clean() {
        TravelAgentList travelAgentList = new TravelAgentList();
        try {
            travelAgentList.clean();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e);
>>>>>>> task3
        }
    }

   /* private TravelAgent buildTravelAgent(ResultSet result) throws SQLException{
        String uid = result.getString("id");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String username = result.getString("username");
        String password = result.getString("password");
        String email = result.getString("email");
        String activationCode = result.getString("activation_code");
        String phoneNumber = result.getString("phone_number");
        String position = result.getString("position");
        String travelAgentId = result.getString("travel_agent_id");
        TravelAgent travelAgent =new TravelAgent(UUID.fromString(uid), firstName, lastName, username, password, email, activationCode, phoneNumber, position, UUID.fromString(travelAgentId));
        travelAgent.setRole(Role.valueOf(result.getString("role")));
        return travelAgent;
    }*/


}
