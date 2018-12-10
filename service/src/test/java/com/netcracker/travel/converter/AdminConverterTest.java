package com.netcracker.travel.converter;

import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.domain.Admin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminConverterTest {

    @Mock
    private Admin admin;
    @Mock
    private AdminDto adminDto;
    private AdminConverter adminConverter;
    private String firstName = "testFirstName";
    private String lastName = "testLastName";
    private UUID id = UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        adminConverter = new AdminConverter();
        admin = mock(Admin.class);
        adminDto = mock(AdminDto.class);
    }

    @Test
    public void testConvertFromDtoToEntity() {
        when(adminDto.getId()).thenReturn(id);
        when(adminDto.getFirstName()).thenReturn(firstName);
        when(adminDto.getLastName()).thenReturn(lastName);
        admin = adminConverter.convert(adminDto);
        Assert.assertNotNull(admin);
        Assert.assertEquals(id, admin.getId());
        Assert.assertEquals(firstName, admin.getFirstName());
        Assert.assertEquals(lastName, admin.getLastName());
    }

    @Test
    public void testConvertFromEntityToDto() {
        when(admin.getId()).thenReturn(id.toString());
        when(admin.getFirstName()).thenReturn(firstName);
        when(admin.getLastName()).thenReturn(lastName);
        adminDto = adminConverter.convert(admin);
        Assert.assertNotNull(adminDto);
        Assert.assertEquals(id, adminDto.getId());
        Assert.assertEquals(firstName, adminDto.getFirstName());
        Assert.assertEquals(lastName, adminDto.getLastName());
    }

    @After
    public void tearDown() {
        admin = null;
        adminDto = null;
    }
}


