package com.netcracker.travel.controller;

import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.service.implementation.AuthenticationServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;
    private LoginRequestDto loginRequestDto;

}