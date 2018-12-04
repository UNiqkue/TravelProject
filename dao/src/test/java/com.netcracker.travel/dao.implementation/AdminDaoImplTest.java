package com.netcracker.travel.dao.implementation;

import com.netcracker.travel.entity.Admin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class AdminDaoImplTest extends Assert {

    private Admin admin;

    @Before
    public void setUp() {
        admin = new Admin(UUID.randomUUID(), "Achik", "Dmin", "Administrator", "null1111", "admin@gmail.com", "qwdqscqwcdqwcd");
    }

    @After
    public void tearDown() {
        admin = null;
    }

    @Test
    public void testGetInstance() throws Exception {
        AdminDaoImpl instance1 = AdminDaoImpl.getInstance();
        AdminDaoImpl instance2 = AdminDaoImpl.getInstance();
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    @Test
    public void testSave() throws Exception {
        AdminDaoImpl.getInstance().save(admin);
        Admin actual = AdminDaoImpl.getInstance().getById(admin.getId());
        Assert.assertEquals(admin, actual);
        AdminDaoImpl.getInstance().delete(admin.getId());
    }

    @Test
    public void testGetById() throws Exception {
        admin.setId(UUID.fromString("5be60162-f667-4f2d-a165-5697b6c1a3b5"));
        Admin actual = AdminDaoImpl.getInstance().getById(admin.getId());
        Assert.assertEquals(admin, actual);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Admin> admins = AdminDaoImpl.getInstance().getAll();
        Assert.assertNotNull(admins);
    }

    @Test
    public void testUpdate() throws Exception {
        AdminDaoImpl.getInstance().save(admin);
        admin.setUsername("Adminchik");
        AdminDaoImpl.getInstance().update(admin);
        Admin actual = AdminDaoImpl.getInstance().getById(admin.getId());
        AdminDaoImpl.getInstance().delete(admin.getId());
        Assert.assertEquals(admin, actual);
    }

    @Test
    public void testDelete() throws Exception {
        AdminDaoImpl.getInstance().save(admin);
        AdminDaoImpl.getInstance().delete(admin.getId());
        Admin actual = AdminDaoImpl.getInstance().getById(admin.getId());
        Assert.assertNull(actual);
    }
}
