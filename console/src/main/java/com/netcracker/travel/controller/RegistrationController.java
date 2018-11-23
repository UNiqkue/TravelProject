package com.netcracker.travel.controller;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class RegistrationController {

    private CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

    public CustomerDto registration() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto();
        boolean exit = false;
        try {
            System.out.println("Please, input the firstName");
            registrationRequestDto.setFirstName(reader.readLine());
            System.out.println("Please, input the lastName");
            registrationRequestDto.setLastName(reader.readLine());
            System.out.println("Please, input the username");
            registrationRequestDto.setUsername(reader.readLine());
            System.out.println("Please, input the password");
            registrationRequestDto.setPassword(reader.readLine());
            System.out.println("Please, input email");
            registrationRequestDto.setEmail(reader.readLine());
            while(exit==false) {
                try {
                    System.out.println("Please, input date of birth");
                    registrationRequestDto.setDateOfBirth(java.sql.Date.valueOf(reader.readLine()));
                } catch(IllegalArgumentException e){
                    System.out.println("You input not corrected date. Example: 2000-10-10");
                }
            }
            System.out.println("Please, input the phoneNumber");
            registrationRequestDto.setPhoneNumber(reader.readLine());
            System.out.println("Please, input the cardNumber");
            registrationRequestDto.setCardNumber(reader.readLine());
            System.out.println("Please, input the passportInfo");
            registrationRequestDto.setPassportInfo(reader.readLine());
            registrationRequestDto.setActivationCode(UUID.randomUUID().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerServiceImpl.registration(registrationRequestDto);
    }

    public boolean activate(RegistrationRequestDto registrationRequestDto) {
        return customerServiceImpl.activate(registrationRequestDto.getActivationCode());
    }
}
