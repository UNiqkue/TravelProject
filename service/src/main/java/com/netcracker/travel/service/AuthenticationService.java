package com.netcracker.travel.service;

import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.TravelAgentDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    CustomerDto loginCustomer(LoginRequestDto loginRequestDto);

    AdminDto loginAdmin(LoginRequestDto loginRequestDto);

    TravelAgentDto loginTravelAgent(LoginRequestDto loginRequestDto);

}
