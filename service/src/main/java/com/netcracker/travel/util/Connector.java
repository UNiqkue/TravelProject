package com.netcracker.travel.util;

import java.sql.*;

public class Connector {

    private String host;
    private String schema;
    private String user;
    private String password;
    private Connection connection;
    private boolean isConnected = false;

    public Connector(String host, String schema, String user, String password) {
        this.host = host;
        this.schema = schema;
        this.user = user;
        this.password = password;
    }

    public void openConnection() throws SQLException{
        if(isConnected){
            return;
        }
        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + schema + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC", user, password);
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getSchema() {
        return schema;
    }
    public void setSchema(String schema) {
        this.schema = schema;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public boolean isConnected() {
        return isConnected;
    }
    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}