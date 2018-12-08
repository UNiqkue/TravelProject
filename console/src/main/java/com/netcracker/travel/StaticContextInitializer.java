package com.netcracker.travel;

import com.netcracker.travel.controller.AuthenticationController;
import com.netcracker.travel.controller.RegistrationController;
import com.netcracker.travel.service.implementation.AdminServiceImpl;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticContextInitializer {

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private TravelAgentServiceImpl travelAgentService;
    @Autowired
    private AuthenticationController authenticationController;
    @Autowired
    private RegistrationController registrationController;

    @PostConstruct
    public void init() {
        Menu.setConfigMenu(adminService, customerService, travelAgentService, authenticationController, registrationController);
        }
}
