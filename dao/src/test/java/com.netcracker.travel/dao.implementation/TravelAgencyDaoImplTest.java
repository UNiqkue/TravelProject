package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.TravelAgency;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class TravelAgencyDaoImplTest {
    TravelAgency travelAgency;

    @Before
    public void setUp() {
        travelAgency = new TravelAgency(UUID.randomUUID(), "CoralTravel", 5, 10);
    }

    @After
    public void tearDown() {
        travelAgency = null;
    }

    @Test
    public void testGetInstance() throws Exception {
        TravelAgencyDaoImpl instance1 = TravelAgencyDaoImpl.getInstance();
        TravelAgencyDaoImpl instance2 = TravelAgencyDaoImpl.getInstance();
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }


    @Test
    public void testSave() throws Exception{
        TravelAgencyDaoImpl.getInstance().save(travelAgency);
        TravelAgency actual = TravelAgencyDaoImpl.getInstance().getById(travelAgency.getId());
        Assert.assertEquals(travelAgency, actual);
        TravelAgencyDaoImpl.getInstance().delete(travelAgency.getId());
    }

    @Test
    public void testGetById() throws Exception {
        travelAgency.setId(UUID.fromString("65cd0390-576b-459c-818d-6d244661ff4a"));
        TravelAgency actual = TravelAgencyDaoImpl.getInstance().getById(travelAgency.getId());
        Assert.assertEquals(travelAgency, actual);
    }

    @Test
    public void testGetAll() throws Exception {
        List<TravelAgency> travelAgencies = TravelAgencyDaoImpl.getInstance().getAll();
        Assert.assertNotNull(travelAgencies);
    }

    @Test
    public void testUpdate() throws Exception {
        TravelAgencyDaoImpl.getInstance().save(travelAgency);
        travelAgency.setName("+375-44-123-54-34");
        TravelAgencyDaoImpl.getInstance().update(travelAgency);
        TravelAgency actual = TravelAgencyDaoImpl.getInstance().getById(travelAgency.getId());
        TravelAgencyDaoImpl.getInstance().delete(travelAgency.getId());
        Assert.assertEquals(travelAgency, actual);
    }

    @Test
    public void testDelete() throws Exception{
        TravelAgencyDaoImpl.getInstance().save(travelAgency);
        TravelAgencyDaoImpl.getInstance().delete(travelAgency.getId());
        TravelAgency actual = TravelAgencyDaoImpl.getInstance().getById(travelAgency.getId());
        Assert.assertNull(actual);
    }
}
