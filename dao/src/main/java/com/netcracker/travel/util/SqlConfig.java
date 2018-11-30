package com.netcracker.travel.util;

public class SqlConfig {

    public static final String ADD_CUSTOMER = "INSERT INTO customer(id, first_name, last_name, username, password, email, activation_code, card_number, date_of_birth, passport_info, phone_number, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM customer where role='CUSTOMER'";
    public static final String DELETE_USER_BY_ID = "DELETE FROM customer WHERE id = ?";
    public static final String GET_USER_BY_USERNAME = "SELECT * FROM customer WHERE username = ?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM customer WHERE email = ?";
    public static final String GET_USER_BY_ID = "SELECT * FROM customer WHERE id = ?";
    public static final String PUT_PHONE = "UPDATE customer SET phoneNumber = ? WHERE id = ?";

    public static final String ADD_ADMIN = "INSERT INTO admin(id, first_name, last_name, username, password, email, activation_code, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_ADMINS = "SELECT * FROM admin where role='ADMIN'";
    public static final String GET_ADMIN_BY_USERNAME = "SELECT * FROM admin WHERE username = ?";
    public static final String GET_ADMIN_BY_ID = "SELECT * FROM admin WHERE id = ?";
    public static final String DELETE_ADMIN_BY_ID = "DELETE FROM admin WHERE id = ?";
    public static final String PUT_ADMIN_USERNAME = "UPDATE admin SET username = ? WHERE id = ?";

    public static final String ADD_TRAVELAGENT = "INSERT INTO travel_agent(id, first_name, last_name, username, password, email, activation_code, phoneNumber, position, travelAgentId, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_TRAVELAGENTS = "SELECT * FROM travel_agent where role='TRAVELAGENT'";
    public static final String GET_TRAVELAGENT_BY_USERNAME = "SELECT * FROM travel_agent WHERE username = ?";
    public static final String GET_TRAVELAGENT_BY_ID = "SELECT * FROM travel_agent WHERE id = ?";
    public static final String DELETE_TRAVELAGENT_BY_ID = "DELETE FROM travel_agent WHERE id = ?";
    public static final String PUT_POSITION = "UPDATE travel_agent SET position = ? WHERE id = ?";

    public static final String ADD_TOUR = "INSERT INTO tour(id, name, description, price, type, country, start_date, end_date, travel_agency_id, customer_id, free) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_TOURS = "SELECT * FROM tour";
    public static final String GET_TOUR_BY_ID = "SELECT * FROM tour WHERE id = ?";
    public static final String MAKE_DISCOUNT = "UPDATE tour SET price = ? WHERE id = ?";
    public static final String DELETE_TOUR_BY_ID = "DELETE FROM tour WHERE id = ?";

    public static final String ADD_TRAVELAGENCY = "INSERT INTO travel_agency(id, name, count_tour, count_travel_agents) VALUES(?, ?, ?, ?)";
    public static final String PUT_NAME = "UPDATE travel_agency SET name = ? WHERE id = ?";
    public static final String GET_TRAVELAGENCY_BY_ID = "SELECT * FROM travel_agency WHERE id = ?";
    public static final String GET_ALL_TRAVELAGENCIES = "SELECT * FROM travel_agency";
    public static final String DELETE_TRAVELAGENCY_BY_ID = "DELETE FROM travel_agency WHERE id = ?";

    private SqlConfig() {
    }
}