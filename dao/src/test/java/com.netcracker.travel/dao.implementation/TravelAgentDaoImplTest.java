package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.TravelAgent;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class TravelAgentDaoImplTest {
    TravelAgent travelAgent;

    @Test
    public void testSave() throws Exception{
        TravelAgentDaoImpl.getInstance().save(travelAgent);
        TravelAgent actual = TravelAgentDaoImpl.getInstance().getById(travelAgent.getId());
        Assert.assertEquals(travelAgent, actual);
        TravelAgentDaoImpl.getInstance().delete(travelAgent.getId());
    }

    @Test
    public void testGetById() throws Exception {
        travelAgent = new TravelAgent(UUID.randomUUID(), "Grisha", "Moloch", "TravelAgent1", "null1111", "TravelAgent@gmail.com", "qwdqscqwcdqwcd", "+375-29-567-23-23", "123123", UUID.randomUUID());
        TravelAgent actual = TravelAgentDaoImpl.getInstance().getById(travelAgent.getId());
        Assert.assertEquals(travelAgent, actual);
    }

    @Test
    public void testUpdate() throws Exception {
        TravelAgentDaoImpl.getInstance().save(travelAgent);
        travelAgent.setPhoneNumber("+375-44-123-54-34");
        TravelAgentDaoImpl.getInstance().update(travelAgent);
        TravelAgent actual = TravelAgentDaoImpl.getInstance().getById(travelAgent.getId());
        TravelAgentDaoImpl.getInstance().delete(travelAgent.getId());
        Assert.assertEquals(travelAgent, actual);
    }

    @Test
    public void testDelete() throws Exception{
        TravelAgentDaoImpl.getInstance().save(travelAgent);
        TravelAgentDaoImpl.getInstance().delete(travelAgent.getId());
        TravelAgent actual = TravelAgentDaoImpl.getInstance().getById(travelAgent.getId());
        Assert.assertNull(actual);
    }


}
