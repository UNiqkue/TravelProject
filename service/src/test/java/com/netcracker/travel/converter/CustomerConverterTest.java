package com.netcracker.travel.converter;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.domain.Customer;
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
public class CustomerConverterTest {

    @Mock
    private Customer customer;
    @Mock
    private CustomerDto customerDto;
    private CustomerConverter customerConverter;
    private String firstName = "testFirstName";
    private String lastName = "testLastName";
    private UUID id = UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        customerConverter = new CustomerConverter();
        customer = mock(Customer.class);
        customerDto = mock(CustomerDto.class);
    }

    @Test
    public void testConvertFromDtoToEntity() {
        when(customerDto.getId()).thenReturn(id);
        when(customerDto.getFirstName()).thenReturn(firstName);
        when(customerDto.getLastName()).thenReturn(lastName);
        customer = customerConverter.convert(customerDto);
        Assert.assertNotNull(customer);
        Assert.assertEquals(id, customer.getId());
        Assert.assertEquals(firstName, customer.getFirstName());
        Assert.assertEquals(lastName, customer.getLastName());
    }

    @Test
    public void testConvertFromEntityToDto() {
        when(customer.getId()).thenReturn(id.toString());
        when(customer.getFirstName()).thenReturn(firstName);
        when(customer.getLastName()).thenReturn(lastName);
        customerDto = customerConverter.convert(customer);
        Assert.assertNotNull(customerDto);
        Assert.assertEquals(id, customerDto.getId());
        Assert.assertEquals(firstName, customerDto.getFirstName());
        Assert.assertEquals(lastName, customerDto.getLastName());
    }

    @After
    public void tearDown() {
        customer = null;
        customerDto = null;
    }
}
