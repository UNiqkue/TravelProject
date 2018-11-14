package com.netcracker.travel.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connector {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String NAME = "root";
    private static final String PASSWORD = "12345";
    private static Connection connection;

    public static void initTables() {
        PropertyDB propertyDB = new PropertyDB();
        try {
            String initTableSQL = Files.readAllLines(Paths.get(propertyDB.getProperty("init.table.path")))
                    .stream()
                    .reduce("", (acc, string) -> acc + string);
            PreparedStatement preparedStatement = getConnection().prepareStatement(initTableSQL);
            preparedStatement.execute();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC", NAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Database exception");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL exception");
        }
    }

    public static String getURL() {
        return URL;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }


}
