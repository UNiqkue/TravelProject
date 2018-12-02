package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.TypeTour;
import com.netcracker.travel.util.ClosingUtil;
import com.netcracker.travel.util.PoolConnector;
import com.netcracker.travel.util.SqlConfig;
import com.netcracker.travel.util.SystemLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TourDaoImpl implements AbstractDao<Tour> {

    private Connection connection = PoolConnector.getInstance().getConnection();
    private PreparedStatement statement;
    private ResultSet result;

    private static volatile TourDaoImpl instance;

    private TourDaoImpl() {

    }

    public static TourDaoImpl getInstance() {
        if (instance == null) {
            synchronized (TourDaoImpl.class) {
                if (instance == null) {
                    instance = new TourDaoImpl();
                }
            }
        }

        return instance;
    }

    public Tour save(Tour tour) {
        try {
            Connection connection = PoolConnector.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConfig.ADD_TOUR);
            statement.setString(1, tour.getId().toString());
            statement.setString(2, tour.getName());
            statement.setString(3, tour.getDescription());
            statement.setDouble(4, tour.getPrice());
            statement.setString(5, tour.getType().toString());
            statement.setString(6, tour.getCountry());
            statement.setDate(7, tour.getStartDate());
            statement.setDate(8, tour.getEndDate());
            statement.setString(9, tour.getTravelAgencyId().toString());
            statement.setString(10, "00000000-0000-0000-0000-000000000000");
            statement.setBoolean(11, tour.isFree());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to add the user account ";
            e.printStackTrace();
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return tour;
    }

    public List<Tour> getAll() {
        List<Tour> list = new ArrayList<>();
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_ALL_TOURS);
            result = statement.executeQuery();
            while (result.next()) {
                Tour tour = new Tour();
                tour.setId(UUID.fromString(result.getString("id")));
                tour.setName(result.getString("name"));
                tour.setDescription(result.getString("description"));
                tour.setPrice(result.getDouble("price"));
                tour.setType(TypeTour.valueOf(result.getString("type")));
                tour.setCountry(result.getString("country"));
                tour.setStartDate(result.getDate("start_date"));
                tour.setEndDate(result.getDate("end_date"));
                tour.setTravelAgencyId(UUID.fromString(result.getString("travel_agency_id")));
                tour.setCustomerId(UUID.fromString(result.getString("customer_id")));
                tour.setFree(result.getBoolean("free"));
                list.add(tour);
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

    public Tour getById(UUID id) {
        Tour tour = null;
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.GET_TOUR_BY_ID);
            statement.setString(1, id.toString());
            result = statement.executeQuery();
            while (result.next()) {
                tour = new Tour();
                tour.setId(UUID.fromString(result.getString("id")));
                tour.setName(result.getString("name"));
                tour.setDescription(result.getString("description"));
                tour.setPrice(result.getDouble("price"));
                tour.setType(TypeTour.valueOf(result.getString("type")));
                tour.setCountry(result.getString("country"));
                tour.setStartDate(result.getDate("start_date"));
                tour.setEndDate(result.getDate("end_date"));
                tour.setTravelAgencyId(UUID.fromString(result.getString("travel_agency_id")));
                tour.setCustomerId(UUID.fromString(result.getString("customer_id")));
                tour.setFree(result.getBoolean("free"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String message = "Unable to return the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return tour;
    }

    public List<Tour> getByName(String name) {
        List<Tour> list = getAll()
                .stream()
                .filter(tour -> tour.getName().equals(name))
                .collect(Collectors.toList());
        return list;
    }


    public List<Tour> getByDate(Date startDate, Date endDate) {
        return getAll()
                .stream()
                .filter(tour -> tour.getStartDate().equals(startDate))
                .filter(tour -> tour.getEndDate().equals(endDate))
                .collect(Collectors.toList());
    }

    public List<Tour> getByCountry(String country) {
        return getAll()
                .stream()
                .filter(tour -> tour.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<Tour> getByType(String type) {
        return getAll()
                .stream()
                .filter(tour -> tour.getType().toString().equals(type))
                .collect(Collectors.toList());
    }

    public List<Tour> getByTravelAgencyId(UUID id) {
        return getAll()
                .stream()
                .filter(tour -> tour.getTravelAgencyId().toString().equals(id.toString()))
                .collect(Collectors.toList());
    }

    public List<Tour> getToursById(UUID customerId) {
        return getAll()
                .stream()
                .filter(tour -> tour.getCustomerId().toString().equals(customerId.toString()))
                .collect(Collectors.toList());
    }

    public Tour update(Tour tour) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_CUSTOMER);
            statement.setString(1, tour.getCustomerId().toString());
            statement.setBoolean(2, tour.isFree());
            statement.setString(3, tour.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return tour;
    }

    public Tour updateCancelTrip(Tour tour) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.CANCEl_TRIP);
            statement.setString(1, "00000000-0000-0000-0000-000000000000");
            statement.setBoolean(2, true);
            statement.setString(3, tour.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return tour;
    }

    public Tour updatePrice(Tour tour) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.MAKE_DISCOUNT);
            statement.setDouble(1, tour.getPrice());
            statement.setString(2, tour.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return tour;
    }

    public Tour updateDescription(Tour tour) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.PUT_DESCRIPTION);
            statement.setString(1, tour.getDescription());
            statement.setString(2, tour.getId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to update amount ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
        return tour;
    }

    public void delete(UUID id) {
        try {
            connection = PoolConnector.getInstance().getConnection();
            statement = connection.prepareStatement(SqlConfig.DELETE_TOUR_BY_ID);
            statement.setString(1, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "Unable to delete the user ";
            SystemLogger.getInstance().logError(getClass(), message);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    private Tour buildTour(ResultSet result) throws SQLException {
        String uid = result.getString("id");
        String name = result.getString("name");
        String description = result.getString("description");
        Double price = result.getDouble("price");
        String type = result.getString("type");
        String country = result.getString("country");
        Date startDate = result.getDate("startDate");
        Date endDate = result.getDate("endDate");
        String travelAgencyId = result.getString("travelAgencyId");
        String customerId = result.getString("customerId");
        boolean free = result.getBoolean("free");
        Tour tour = new Tour(UUID.fromString(uid), name, description, price, TypeTour.valueOf(type), country, startDate, endDate, UUID.fromString(travelAgencyId), UUID.fromString(customerId), free);
        return tour;
    }


}

