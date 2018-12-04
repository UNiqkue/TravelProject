package com.netcracker.travel.service.implementation;

import com.netcracker.travel.dto.LoginRequestDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AuthenticationServiceImplTest {

    @Mock
    private AuthenticationServiceImpl authenticationService;
    private LoginRequestDto loginRequestDto;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        authenticationService =new AuthenticationServiceImpl();
        loginRequestDto = new LoginRequestDto();
    }

    @After
    public void tearDown() {
        authenticationService = null;
        loginRequestDto = null;
    }

    @Test
    public void loginAdminTest() throws Exception {
        int expected = 1;
        loginRequestDto.setUsername("Administrator");
        loginRequestDto.setPassword("null1111");
        int actual = authenticationService.login(loginRequestDto);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void loginCustomerTest() throws Exception {
        int expected = 2;
        loginRequestDto.setUsername("Customer1");
        loginRequestDto.setPassword("null1111");
        int actual = authenticationService.login(loginRequestDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void loginTravelAgentTest() throws Exception {
        int expected = 3;
        loginRequestDto.setUsername("TravelAgent1");
        loginRequestDto.setPassword("null1111");
        int actual = authenticationService.login(loginRequestDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void loginNullTest() throws Exception {
        int expected = 0;
        loginRequestDto.setUsername("Qqwertyuio");
        loginRequestDto.setPassword("12345678");
        int actual = authenticationService.login(loginRequestDto);
        Assert.assertEquals(expected, actual);
    }
}
