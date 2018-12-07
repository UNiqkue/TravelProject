package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.LoginRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    boolean loginCustomer(LoginRequestDto loginRequestDto);

    boolean loginAdmin(LoginRequestDto loginRequestDto);

    boolean loginTravelAgent(LoginRequestDto loginRequestDto);
}
