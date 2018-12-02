package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.AdminDaoImpl;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.service.interfaces.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {

    private AdminDaoImpl adminDao = AdminDaoImpl.getInstance();
    private CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private AdminConverter adminConverter = new AdminConverter();
    private CustomerConverter customerConverter = new CustomerConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();

    public AuthenticationServiceImpl() {
    }

    public int login(LoginRequestDto loginRequestDto) {
        return 0;
    }



}
