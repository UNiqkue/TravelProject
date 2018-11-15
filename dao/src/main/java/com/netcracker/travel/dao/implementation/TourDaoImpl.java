package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.dao.interfaces.AbstractDao;
import com.netcracker.travel.entity.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TourDaoImpl implements AbstractDao<Tour> {

    private Connection connection;

    private static volatile TourDaoImpl instance;

    private TourDaoImpl(){

    }

    public static TourDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TourDaoImpl.class) {
                if (instance == null) {
                    instance = new TourDaoImpl();
                }
            }
        }

        return instance;
    }

   /* public Collection<Tour> getEntityMapValues(){
        FileEntityMap.readEntityMap("README.md");
        return tourMap.values();
    }

    private Map getEntityMap() {
        return AbstractDao.entityMap;
    }*/

    private Tour setResultTour(ResultSet resultSet) throws SQLException {
        Tour tour = new Tour();
        tour.setId(UUID.fromString(resultSet.getString("id")));
        tour.setName(resultSet.getString("name"));
        tour.setDescription(resultSet.getString("description"));
        tour.setPrice(resultSet.getDouble("price"));
        tour.setCountry(resultSet.getString("country"));
        tour.setStartDate(resultSet.getDate("startDate"));
        tour.setEndDate(resultSet.getDate("endDate"));
        return tour;
    }

    public Tour getById(UUID id) throws SQLException {
        Tour tour = null;
        String uuid = id.toString();

        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM tour WHERE uuid=?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tour = setResultTour(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return tour;
    }

   public Tour getByName(String name) throws SQLException {
       Tour tour = null;
       PreparedStatement preparedStatement = connection.prepareStatement("" +
               "SELECT * FROM tour WHERE name=?");
       preparedStatement.setString(1, name);
       ResultSet resultSet = preparedStatement.executeQuery();
       if (resultSet.next()) {
           tour = setResultTour(resultSet);
       }
       resultSet.close();
       preparedStatement.close();
       return tour;
    }

    public Tour getByDate(Date startDate, Date endDate) throws SQLException {
        Tour tour = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM tour WHERE startDate=? and endDate=?");
        preparedStatement.setDate(1, startDate);
        preparedStatement.setDate(2, endDate);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tour = setResultTour(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return tour;
    }

    public Tour getByCountry(String country) throws SQLException {
        Tour tour = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM tour WHERE country=?");
        preparedStatement.setString(1, country);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tour = setResultTour(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return tour;
    }

    /****Изменить на Enum
    public Tour getByType(String type) throws SQLException {
        Tour tour = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM tour WHERE type=?");
        preparedStatement.setString(1, type);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tour = setResultTour(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return tour;
    }
     */////

    public List<Tour> getAll() throws SQLException {
        List<Tour> toursList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM tour");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            toursList.add(setResultTour(resultSet));
        }
        resultSet.close();
        preparedStatement.close();
        return toursList;
    }

    public Tour save(Tour entity) throws SQLException {
        Tour tour = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "INSERT INTO user(name, description, price, country, startDate, endDate)" +
                "VALUES(?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setDouble(3, entity.getPrice());
        preparedStatement.setString(4, entity.getCountry());
        preparedStatement.setDate(5, entity.getStartDate());
        preparedStatement.setDate(6, entity.getEndDate());
        preparedStatement.execute();
        preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM user WHERE id=?");
        preparedStatement.setString(1, entity.getId().toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tour = setResultTour(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return tour;
    }

    public Tour update(Tour entity) throws SQLException {
        Tour tour = null;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "UPDATE tour SET name=?, description=?, price=?, country=?, startDate=?, endDate=? WHERE id=?");
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setDouble(3, entity.getPrice());
        preparedStatement.setString(4, entity.getCountry());
        preparedStatement.setDate(5, entity.getStartDate());
        preparedStatement.setDate(6, entity.getEndDate());
        preparedStatement.execute();
        preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM tour WHERE id=?");
        preparedStatement.setString(1, entity.getId().toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tour = setResultTour(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return tour;
    }


    public void delete(UUID id) throws SQLException {

        String uuid = id.toString();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "DELETE FROM tour WHERE  id=?");
        preparedStatement.setString(1, uuid);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public List<Tour> getToursById(UUID customerId) throws SQLException {
        List<Tour> tours = new ArrayList<>();
        String uuid = customerId.toString();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT * FROM tour WHERE customerId=?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            tours.add(setResultTour(resultSet));
        }
        resultSet.close();
        preparedStatement.close();
        return tours;
    }
/*
    public List<Tour> getTourByCustomerId(UUID customerId) throws SQLException {
        List<Tour> toursList = new ArrayList<>();
        String uuid = customerId.toString();
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT id FROM tour WHERE customer_id IN (SELECT id FROM user WHERE id=?)");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            toursList.add(setResultTour(resultSet));
        }
        resultSet.close();
        preparedStatement.close();
        return toursList;
    }*/

}

/*
 tours.add(new Tour(UUID.randomUUID().toString(), "Тур с отдыхом в Испании на 12 дней",
                    "Раннее бронирование до 1-го марта. 8 дней на море в Испании+Барселона",
                         310.0, Collections.singleton(TypeTour.CRUISE), "Испания",
                             Date.valueOf("2018-10-28"), Date.valueOf("2018-11-07")));
        tours.add(new Tour(UUID.randomUUID().toString(),"Тур в Португалию на 14 дней",
                "Раннее бронирование до 1-го марта. Эксклюзив! Франкфурт-Париж-Мадрид-6 дней в Португалии-Барселона-Женева-Страсбург.",
                475.0, Collections.singleton(TypeTour.EXCURSION), "Португалия",
                Date.valueOf("2018-10-30"), Date.valueOf("2018-11-13")));
        tours.add(new Tour(UUID.randomUUID().toString();,"Отдых на Крите",
                "самый большой остров в Греции и пятый по величине в Средиземноморье.",
                999.50, Collections.singleton(TypeTour.HOTELRESTTOUR), "Greece",
                Date.valueOf("2019-06-20"), Date.valueOf("2019-07-04")));
 */
