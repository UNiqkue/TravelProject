package com.netcracker.travel.controller;

import com.netcracker.travel.dto.LoginRequestDto;

public class AuthenticationController {

    public void login(LoginRequestDto loginRequestDto){
        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
       // return userServiceImpl.login(loginRequestDto);
    }
}
