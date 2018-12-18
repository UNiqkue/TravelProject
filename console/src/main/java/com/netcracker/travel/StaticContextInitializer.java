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

    private final AdminServiceImpl adminService;
    private final CustomerServiceImpl customerService;
    private final TravelAgentServiceImpl travelAgentService;
    private final AuthenticationController authenticationController;
    private final RegistrationController registrationController;

    @Autowired
    public StaticContextInitializer(AdminServiceImpl adminService, CustomerServiceImpl customerService, TravelAgentServiceImpl travelAgentService, AuthenticationController authenticationController, RegistrationController registrationController) {
        this.adminService = adminService;
        this.customerService = customerService;
        this.travelAgentService = travelAgentService;
        this.authenticationController = authenticationController;
        this.registrationController = registrationController;
    }

    @PostConstruct
    public void init() {
        Menu.setConfigMenu(adminService, customerService, travelAgentService, authenticationController, registrationController);
    }
}
