package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.TravelAgent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class TravelAgentDaoImplTest {
    private TravelAgent travelAgent;

    @Before
    public void setUp() {
        travelAgent = new TravelAgent(UUID.randomUUID(), "Grisha", "Moloch", "TravelAgent1", "null1111", "TravelAgent@gmail.com", "qwdqscqwcdqwcd", "+375-29-567-23-23", "123123", UUID.fromString("65cd0390-576b-459c-818d-6d244661ff4a"));
    }

    @After
    public void tearDown() {
        travelAgent = null;
    }

    @Test
    public void testGetInstance() throws Exception {
        TravelAgentDaoImpl instance1 = TravelAgentDaoImpl.getInstance();
        TravelAgentDaoImpl instance2 = TravelAgentDaoImpl.getInstance();
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    @Test
    public void testSave() throws Exception {
        TravelAgentDaoImpl.getInstance().save(travelAgent);
        TravelAgent actual = TravelAgentDaoImpl.getInstance().getById(travelAgent.getId());
        Assert.assertEquals(travelAgent, actual);
        TravelAgentDaoImpl.getInstance().delete(travelAgent.getId());
    }

    @Test
    public void testGetById() throws Exception {
        travelAgent.setId(UUID.fromString("851eee22-9170-4310-832f-bbb22c6d033b"));
        TravelAgent actual = TravelAgentDaoImpl.getInstance().getById(travelAgent.getId());
        Assert.assertEquals(travelAgent, actual);
    }

    @Test
    public void testGetAll() throws Exception {
        List<TravelAgent> travelAgents = TravelAgentDaoImpl.getInstance().getAll();
        Assert.assertNotNull(travelAgents);
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
    public void testDelete() throws Exception {
        TravelAgentDaoImpl.getInstance().save(travelAgent);
        TravelAgentDaoImpl.getInstance().delete(travelAgent.getId());
        TravelAgent actual = TravelAgentDaoImpl.getInstance().getById(travelAgent.getId());
        Assert.assertNull(actual);
    }


}
