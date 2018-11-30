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
import org.json.JSONException;

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

    public int login(LoginRequestDto loginRequestDto) {
        try {
            try {
                CustomerDto customerDto = customerConverter.convert(customerDao.getByUsername(loginRequestDto.getUsername()));
                if (customerDto.getPassword().equals(loginRequestDto.getPassword())) {
                    return 2;
                }

            } catch (NoSuchElementException e) {
                System.out.println("Load...");
            }

            try {
                AdminDto adminDto = adminConverter.convert(adminDao.getByUsername(loginRequestDto.getUsername()));
                if (adminDto.getPassword().equals(loginRequestDto.getPassword())) {
                    return 1;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Loaddd.....");
            } catch (JSONException e) {

            }

//                try {
            TravelAgentDto travelAgentDto = travelAgentConverter.convert(travelAgentDao.getByUsername(loginRequestDto.getUsername()));
            if (travelAgentDto.getPassword().equals(loginRequestDto.getPassword())) {
                return 3;
            }
//                } catch (JSONException e){
//                    return 0;
//                    }

        } catch (NoSuchElementException e) {
            System.out.println("Loaddddd.......");
        }

        return 0;
    }


}
