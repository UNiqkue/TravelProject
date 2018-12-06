package com.netcracker.travel.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PoolConnector {
    private static PoolConnector instance;
    private BasicDataSource dataSource;

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    public PoolConnector() {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(bundle.getString("database.driver"));
        dataSource.setUsername(bundle.getString("database.user"));
        dataSource.setPassword(bundle.getString("database.password"));
        dataSource.setUrl(bundle.getString("database.url"));
    }

    public static synchronized PoolConnector getInstance() {
        if (instance == null) {
            instance = new PoolConnector();
        }
        return instance;
    }

    private Connection connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public Connection getConnection() {
        try {
            if (connectionHolder.get() == null) {
                Connection connection = connect();
                connectionHolder.set(connection);
            }
        } catch (SQLException e) {
            String message = "Unable to get connection";
        }
        return connectionHolder.get();
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                connectionHolder.remove();
            } catch (SQLException e) {
                SystemLogger.getInstance().logError(getClass(), e.getMessage());
            }
        }
    }
}