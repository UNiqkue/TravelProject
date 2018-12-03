package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class CustomerDaoImplTest extends Assert {

    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer(UUID.randomUUID(), "Vova", "Dinkevich", "Customer1", "null1111", "Customer@gmail.com", "qwdqscqwcdqwcd", "+375-29-567-23-23", Date.valueOf("2000-10-10"), "123123", "123123");
    }

    @After
    public void tearDown() {
        customer = null;
    }

    @Test
    public void testGetInstance() throws Exception {
        CustomerDaoImpl instance1 = CustomerDaoImpl.getInstance();
        CustomerDaoImpl instance2 = CustomerDaoImpl.getInstance();
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }


    @Test
    public void testSave() throws Exception {
        CustomerDaoImpl.getInstance().save(customer);
        Customer actual = CustomerDaoImpl.getInstance().getById(customer.getId());
        Assert.assertEquals(customer, actual);
        CustomerDaoImpl.getInstance().delete(customer.getId());
    }

    @Test
    public void testGetById() throws Exception {
        customer.setId(UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228"));
        Customer actual = CustomerDaoImpl.getInstance().getById(customer.getId());
        Assert.assertEquals(customer, actual);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Customer> customers = CustomerDaoImpl.getInstance().getAll();
        Assert.assertNotNull(customers);
    }

    @Test
    public void testUpdate() throws Exception {
        CustomerDaoImpl.getInstance().save(customer);
        customer.setPhoneNumber("+375-44-123-54-34");
        CustomerDaoImpl.getInstance().update(customer);
        Customer actual = CustomerDaoImpl.getInstance().getById(customer.getId());
        CustomerDaoImpl.getInstance().delete(customer.getId());
        Assert.assertEquals(customer, actual);
    }

    @Test
    public void testDelete() throws Exception {
        CustomerDaoImpl.getInstance().save(customer);
        CustomerDaoImpl.getInstance().delete(customer.getId());
        Customer actual = CustomerDaoImpl.getInstance().getById(customer.getId());
        Assert.assertNull(actual);
    }
}
