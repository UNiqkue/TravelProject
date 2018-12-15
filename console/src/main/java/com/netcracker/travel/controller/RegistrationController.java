package com.netcracker.travel.controller;

import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RestController
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

}
