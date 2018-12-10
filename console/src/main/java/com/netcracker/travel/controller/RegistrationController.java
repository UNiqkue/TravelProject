package com.netcracker.travel.controller;

import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

}
