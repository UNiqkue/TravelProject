package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.TypeTour;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class TourDaoImplTest {

    private Tour tour;

    @Before
    public void setUp() {
        tour = new Tour(UUID.randomUUID(), "Tour by sea", "Dinkevich", 100.0, TypeTour.CRUISE, "Tailand", Date.valueOf("2000-10-10"), Date.valueOf("2000-10-10"), UUID.fromString("65cd0390-576b-459c-818d-6d244661ff4a"), UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228"), true);
    }

    @After
    public void tearDown() {
        tour = null;
    }

    @Test
    public void testGetInstance() throws Exception {
        TourDaoImpl instance1 = TourDaoImpl.getInstance();
        TourDaoImpl instance2 = TourDaoImpl.getInstance();
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    @Test
    public void testSave() throws Exception {
        tour = TourDaoImpl.getInstance().save(tour);
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        Assert.assertEquals(tour, actual);
        TourDaoImpl.getInstance().delete(tour.getId());
    }

    @Test
    public void testGetAll() throws Exception {
        List<Tour> tours= TourDaoImpl.getInstance().getAll();
        Assert.assertNotNull(tours);
    }

    @Test
    public void testGetById() throws Exception {
        tour.setId(UUID.fromString("12ef3a14-9a12-4ee9-9dd5-90a92161aec7"));
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        Assert.assertEquals(tour, actual);
    }

    @Test
    public void testUpdate() throws Exception {
        TourDaoImpl.getInstance().save(tour);
        tour.setPrice(10.0);
        TourDaoImpl.getInstance().updatePrice(tour);
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        TourDaoImpl.getInstance().delete(tour.getId());
        Assert.assertEquals(tour, actual);
    }

    @Test
    public void testDelete() throws Exception {
        TourDaoImpl.getInstance().save(tour);
        TourDaoImpl.getInstance().delete(tour.getId());
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        Assert.assertNull(actual);
    }
}
