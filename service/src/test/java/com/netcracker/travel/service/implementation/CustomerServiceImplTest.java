package com.netcracker.travel.service.implementation;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.exception.PhoneNumberException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl();
    }

    @Test
    public void verifyPhoneNumberTest() throws PhoneNumberException, Exception {
        PhoneNumberException exception = new PhoneNumberException();
        //customerService.verifyPhoneNumber();
        doThrow(exception).when(customerService).verifyPhoneNumber("1234567890");
    }

    @Test
    public void registrationTest(){
        RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setUsername("qwerty");
        customerDto.setPassword("1234567");
        registrationRequestDto.setUsername("qwerty");
        registrationRequestDto.setPassword("1234567");
        when(customerService.registration(registrationRequestDto)).thenReturn(customerDto);

    }

    @After
    public void tearDown(){
        customerService = null;
    }
}
