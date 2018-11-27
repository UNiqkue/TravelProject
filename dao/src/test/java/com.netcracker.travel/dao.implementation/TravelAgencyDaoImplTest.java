package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.TravelAgency;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class TravelAgencyDaoImplTest {
    TravelAgency travelAgency;

    @Test
    public void testSave() throws Exception{
        TravelAgencyDaoImpl.getInstance().save(travelAgency);
        TravelAgency actual = TravelAgencyDaoImpl.getInstance().getById(travelAgency.getId());
        Assert.assertEquals(travelAgency, actual);
        TravelAgencyDaoImpl.getInstance().delete(travelAgency.getId());
    }

    @Test
    public void testGetById() throws Exception {
        travelAgency = new TravelAgency(UUID.randomUUID(), "TravelAgency1", 10, 15);
        TravelAgency actual = TravelAgencyDaoImpl.getInstance().getById(travelAgency.getId());
        Assert.assertEquals(travelAgency, actual);
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
