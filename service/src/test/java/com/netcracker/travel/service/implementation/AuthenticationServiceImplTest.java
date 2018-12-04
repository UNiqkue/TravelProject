package com.netcracker.travel.service.implementation;

import com.netcracker.travel.dto.LoginRequestDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {

    @Mock
    private AuthenticationServiceImpl authenticationService;
    private LoginRequestDto loginRequestDto;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        authenticationService = null;
        loginRequestDto = null;
    }

    @Test
    public void testLoginCustomer() throws Exception {
        loginRequestDto = new LoginRequestDto("Customer1", "null1111");
        when(authenticationService.loginCustomer(loginRequestDto)).thenReturn(true);
        Assert.assertTrue(authenticationService.loginCustomer(loginRequestDto));
    }

    @Test
    public void testLoginAdmin() throws Exception {
        loginRequestDto = new LoginRequestDto("Administrator", "null1111");
        when(authenticationService.loginAdmin(loginRequestDto)).thenReturn(true);
        Assert.assertTrue(authenticationService.loginAdmin(loginRequestDto));
    }

    @Test
    public void testLoginTravelAgent() throws Exception {
        loginRequestDto = new LoginRequestDto("TravelAgent1", "null1111");
        when(authenticationService.loginTravelAgent(loginRequestDto)).thenReturn(true);
        Assert.assertTrue(authenticationService.loginTravelAgent(loginRequestDto));
    }

    @Test
    public void testLoginNull() throws Exception {
        loginRequestDto = new LoginRequestDto("QWERTYU", "0987654321");
        when(authenticationService.loginCustomer(loginRequestDto)).thenReturn(false);
        Assert.assertFalse(authenticationService.loginCustomer(loginRequestDto));
    }


}
