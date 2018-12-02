package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Admin;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.util.ClosingUtil;
import com.netcracker.travel.util.PoolConnector;
import com.netcracker.travel.util.SqlConfig;
import com.netcracker.travel.util.SystemLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class AdminDaoImpl implements AbstractDao<Admin> {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;

    private static volatile AdminDaoImpl instance;

    private AdminDaoImpl() {
    }

    public static AdminDaoImpl getInstance() {
        if (instance == null) {
            synchronized (AdminDaoImpl.class) {
                if (instance == null) {
                    instance = new AdminDaoImpl();
                }
            }
        }
        return instance;
    }

    public Admin save(Admin admin) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.ADD_ADMIN);
            statement.setString(1, admin.getId().toString());
            statement.setString(2, admin.getFirstName());
            statement.setString(3, admin.getLastName());
            statement.setString(4, admin.getUsername());
            statement.setString(5, admin.getPassword());
            statement.setString(6, admin.getEmail());
            statement.setString(7, admin.getActivationCode());
            statement.setString(8, Role.ADMIN.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to add the user account ";
            e.printStackTrace();
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return admin;
    }

    public List<Admin> getAll() {
        List<Admin> list = new ArrayList<>();
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ALL_ADMINS);
            result = statement.executeQuery();
            while (result.next()) {
                Admin admin = new Admin();
                admin.setId(UUID.fromString(result.getString("id")));
                admin.setFirstName(result.getString("first_name"));
                admin.setLastName(result.getString("last_name"));
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));
                admin.setEmail(result.getString("email"));
                admin.setActivationCode(result.getString("activation_code"));
                admin.setRole(Role.valueOf(result.getString("role")));
                list.add(admin);
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

    public Admin getById(UUID id) {
        Admin admin = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ADMIN_BY_ID);
            statement.setString(1, id.toString());
            result = statement.executeQuery();
            while (result.next()) {
                admin = new Admin();
                admin.setId(UUID.fromString(result.getString("id")));
                admin.setFirstName(result.getString("first_name"));
                admin.setLastName(result.getString("last_name"));
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));
                admin.setEmail(result.getString("email"));
                admin.setActivationCode(result.getString("activation_code"));
                admin.setRole(Role.valueOf(result.getString("role")));
            }
        } catch (SQLException e) {
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return admin;
    }

    public List<Admin> getByName(String lastName) {
        List<Admin> list = getAll()
                .stream()
                .filter(admin -> admin.getLastName().equals(lastName))
                .collect(Collectors.toList());
        return list;
    }

    public Admin getByUsername(String username) {
        Admin admin = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ADMIN_BY_USERNAME);
            statement.setString(1, username);
            result = statement.executeQuery();
            while (result.next()) {
                admin = new Admin();
                admin.setId(UUID.fromString(result.getString("id")));
                admin.setFirstName(result.getString("first_name"));
                admin.setLastName(result.getString("last_name"));
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));
                admin.setEmail(result.getString("email"));
                admin.setActivationCode(result.getString("activation_code"));
                admin.setRole(Role.valueOf(result.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return admin;
    }


    public Admin update(Admin admin) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_ADMIN_USERNAME);
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return admin;
    }

    public void delete(UUID id) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.DELETE_ADMIN_BY_ID);
            statement.setString(1, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to delete the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    private Admin buildAdmin(ResultSet result) throws SQLException {
        String uid = result.getString("id");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String username = result.getString("username");
        String password = result.getString("password");
        String email = result.getString("email");
        String activationCode = result.getString("activation_code");
        Admin admin = new Admin(UUID.fromString(uid), firstName, lastName, username, password, email, activationCode);
        admin.setRole(Role.valueOf(result.getString("role")));
        return admin;
    }

}
