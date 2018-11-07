package com.netcracker.travel.controller;

import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;
import com.netcracker.travel.service.implementation.UserServiceImpl;

public class AuthenticationController {

    private UserServiceImpl userServiceImpl;
    private CustomerServiceImpl customerServiceImpl;
    private TravelAgentServiceImpl travelAgentServiceImpl;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){

        return null;
    }
}
