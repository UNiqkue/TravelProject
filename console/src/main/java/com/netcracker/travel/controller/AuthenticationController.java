package com.netcracker.travel.controller;

import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;
import com.netcracker.travel.service.implementation.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthenticationController {

    public void login() throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        TravelAgentServiceImpl travelAgentService = new TravelAgentServiceImpl();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, input the username:");
        String username = reader.readLine();

        System.out.println("Please, input the password:");
        String password = reader.readLine();

        LoginRequestDto loginRequestDto = new LoginRequestDto(username, password);

        userService.login(loginRequestDto);
        customerService.login(loginRequestDto);
        travelAgentService.login(loginRequestDto);

        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
       // return userServiceImpl.login(loginRequestDto);
    }
}
