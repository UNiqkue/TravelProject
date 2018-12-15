package com.netcracker.travel.service;

import com.netcracker.travel.dto.AdminDTO;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.LoginRequestDTO;
import com.netcracker.travel.dto.TravelAgentDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    CustomerDTO loginCustomer(LoginRequestDTO loginRequestDto);

    AdminDTO loginAdmin(LoginRequestDTO loginRequestDto);

    TravelAgentDTO loginTravelAgent(LoginRequestDTO loginRequestDto);

}
