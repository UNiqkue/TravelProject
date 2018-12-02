package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.LoginRequestDto;

public interface AuthenticationService {

    int login(LoginRequestDto loginRequestDto);
}
