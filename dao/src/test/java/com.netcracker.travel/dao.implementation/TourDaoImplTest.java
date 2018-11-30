package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.TypeTour;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.UUID;

public class TourDaoImplTest {

    Tour tour = new Tour(UUID.randomUUID(), "Tour by sea", "Dinkevich", 100.0, TypeTour.CRUISE, "Tailand", Date.valueOf("2000-10-10"), Date.valueOf("2000-10-10"), UUID.fromString("65cd0390-576b-459c-818d-6d244661ff4a"), UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228"), true);


    @Test
    public void testSave() throws Exception{
        tour = TourDaoImpl.getInstance().save(tour);
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        Assert.assertEquals(tour, actual);
        TourDaoImpl.getInstance().delete(tour.getId());
    }

    @Test
    public void testGetById() throws Exception {
        tour.setId(UUID.fromString("2be61a8a-3fa7-4f2d-a592-054de4f010dc"));
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        Assert.assertEquals(tour, actual);
    }

    @Test
    public void testUpdate() throws Exception {
        TourDaoImpl.getInstance().save(tour);
        tour.setPrice(10.0);
        TourDaoImpl.getInstance().update(tour);
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        TourDaoImpl.getInstance().delete(tour.getId());
        Assert.assertEquals(tour, actual);
    }

    @Test
    public void testDelete() throws Exception{
        TourDaoImpl.getInstance().save(tour);
        TourDaoImpl.getInstance().delete(tour.getId());
        Tour actual = TourDaoImpl.getInstance().getById(tour.getId());
        Assert.assertNull(actual);
    }
}
