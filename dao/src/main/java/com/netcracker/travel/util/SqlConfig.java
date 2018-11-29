package com.netcracker.travel.util;

public class SqlConfig {

    public static final String ADD_CUSTOMER = "INSERT INTO user(id, firstName, lastName, username, password, email, activationCode, cardNumber, dateOfBirth, passportInfo, phoneNumber, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM user where role='CUSTOMER'";
    public static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ?";
    public static final String GET_USER_BY_USERNAME = "SELECT * FROM user WHERE username = ?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String PUT_PHONE = "UPDATE user SET phoneNumber = ? WHERE id = ?";

    public static final String ADD_ADMIN = "INSERT INTO admin(id, firstName, lastName, username, password, email, activationCode, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_ADMINS = "SELECT * FROM admin where role='ADMIN'";
    public static final String GET_ADMIN_BY_USERNAME = "SELECT * FROM admin WHERE username = ?";
    public static final String GET_ADMIN_BY_ID = "SELECT * FROM admin WHERE id = ?";
    public static final String DELETE_ADMIN_BY_ID = "DELETE FROM admin WHERE id = ?";
    public static final String PUT_ADMIN_USERNAME  = "UPDATE admin SET username = ? WHERE id = ?";

    public static final String ADD_TRAVELAGENT = "INSERT INTO user(id, firstName, lastName, username, password, email, activationCode, phoneNumber, position, travelAgentId, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_TRAVELAGENTS = "SELECT * FROM user where role='TRAVELAGENT'";

    public static final String ADD_TOUR = "INSERT INTO tour(id, name, description, price, type, country, startDate, endDate, travelAgencyId, customerId, free) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_TOURS = "SELECT * FROM tour";
    public static final String GET_TOUR_BY_ID = "SELECT * FROM tour WHERE id = ?";
    public static final String MAKE_DISCOUNT = "UPDATE tour SET price = ? WHERE id = ?";
    public static final String DELETE_TOUR_BY_ID = "DELETE FROM tour WHERE id = ?";

    public static final String ADD_TRAVELAGENCY = "INSERT INTO travelAgency(id, name, countTour, countTravelAgent) VALUES(?, ?, ?, ?)";
    public static final String PUT_NAME = "UPDATE travelAgency SET name = ? WHERE id = ?";
    public static final String GET_TRAVELAGENCY_BY_ID = "SELECT * FROM travelAgency WHERE id = ?";
    public static final String GET_ALL_TRAVELAGENCIES = "SELECT * FROM travelAgency";
    public static final String DELETE_TRAVELAGENCY_BY_ID = "DELETE FROM travelAgency WHERE id = ?";

    private SqlConfig() {}
}