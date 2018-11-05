package com.netcracker.travel.controllers;

import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.services.implementation.CustomerServiceImpl;
import com.netcracker.travel.services.implementation.TravelAgentServiceImpl;
import com.netcracker.travel.services.implementation.UserServiceImpl;

public class AuthenticationController {

    private UserServiceImpl userServiceImpl;
    private CustomerServiceImpl customerServiceImpl;
    private TravelAgentServiceImpl travelAgentServiceImpl;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){return null;}
}
