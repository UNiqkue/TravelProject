package com.netcracker.travel.controller;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.exception.UsernameExistException;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class RegistrationController {

    private CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

    public CustomerDto registration() throws UsernameExistException, EmailExistException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomerServiceImpl customerService = new CustomerServiceImpl();
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
                if(registrationRequestDto.getDateOfBirth()!=null){
                    exit=true;
                }
            }
            boolean exit3 = false;
            while (!exit3) {
                try {
                    String phoneNumber0 = "";
                    boolean exit5 = false;
                    while (!exit5) {
                        System.out.println("Input phoneNumber");
                        phoneNumber0 = reader.readLine();
                        try {
                            customerService.verifyPhoneNumber(phoneNumber0);
                            exit5 = true;
                        } catch (PhoneNumberException e) {
                            System.out.println("Invalid phone number. Example: +375/80-29-234-43-34");
                        }

                    }
                    String phoneNumber = phoneNumber0;
                    registrationRequestDto.setPhoneNumber(phoneNumber);
                    exit3 = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
