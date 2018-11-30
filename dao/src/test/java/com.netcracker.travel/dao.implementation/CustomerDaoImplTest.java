package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.UUID;

public class CustomerDaoImplTest {

    Customer customer = new Customer(UUID.randomUUID(), "Vova", "Dinkevich", "Customer1", "null1111", "Customer@gmail.com", "qwdqscqwcdqwcd", "+375-29-567-23-23", Date.valueOf("2000-10-10"), "123123", "123123");

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
