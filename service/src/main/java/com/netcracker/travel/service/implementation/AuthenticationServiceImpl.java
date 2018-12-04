package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.AdminDaoImpl;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.interfaces.AuthenticationService;

import java.util.NoSuchElementException;

public class AuthenticationServiceImpl implements AuthenticationService {

    private AdminDaoImpl adminDao = AdminDaoImpl.getInstance();
    private CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();
    private TravelAgentDaoImpl travelAgentDao = TravelAgentDaoImpl.getInstance();

    private AdminConverter adminConverter = new AdminConverter();
    private CustomerConverter customerConverter = new CustomerConverter();
    private TravelAgentConverter travelAgentConverter = new TravelAgentConverter();

    public AuthenticationServiceImpl() {
    }

    public boolean loginCustomer(LoginRequestDto loginRequestDto){
        try {
            CustomerDto customerDto = customerConverter.convert(customerDao.getByUsername(loginRequestDto.getUsername()));
            if (customerDto.getPassword().equals(loginRequestDto.getPassword())) {
                return true;
            }
        } catch (NoSuchElementException e) {
            printErrorLogin();
        }
        return false;
    }

    public boolean loginAdmin(LoginRequestDto loginRequestDto){
        try {
            AdminDto adminDto = adminConverter.convert(adminDao.getByUsername(loginRequestDto.getUsername()));
            if (adminDto.getPassword().equals(loginRequestDto.getPassword())) {
                return true;
            }
        } catch (NoSuchElementException e) {
            printErrorLogin();
        }
        return false;
    }

    public boolean loginTravelAgent(LoginRequestDto loginRequestDto){
        try {
            TravelAgentDto travelAgentDto = travelAgentConverter.convert(travelAgentDao.getByUsername(loginRequestDto.getUsername()));
            if (travelAgentDto.getPassword().equals(loginRequestDto.getPassword())) {
                return true;
            }
        } catch (NoSuchElementException e) {
            printErrorLogin();
        }
        return false;
    }

    private void printErrorLogin(){
        System.out.println("You input not corrected username");
    }


}
