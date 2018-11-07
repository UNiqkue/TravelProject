package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;

public interface AuthenticationService{

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
