package com.netcracker.travel;

import com.netcracker.travel.controllers.AuthenticationController;
import com.netcracker.travel.controllers.RegistrationController;
import com.netcracker.travel.controllers.TourController;
import com.netcracker.travel.daos.implementation.TourDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.RegistrationRequestDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        TourDaoImpl tourDao = TourDaoImpl.getInstance();
        System.out.println(tourDao.getAll());
        System.out.println("Hello! You are in TravelSystem! Please, choose the action number: \n 1. Watch tours \n 2. Log in \n 3. Registration \n 0. Exit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        try {
            x = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch(x){
            case 1:
                TourController tourController = new TourController();
                tourController.getAllTours();
                break;
            case 2:
                AuthenticationController authenticationController = new AuthenticationController();
                LoginRequestDto loginRequestDto = new LoginRequestDto("User", "12345");
                authenticationController.login(loginRequestDto);
                break;
            case 3:
                RegistrationController registrationController = new RegistrationController();
                RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto("User", "12345", "awd@gmail.com", "/user/id");
                registrationController.registration(registrationRequestDto);
                break;

            case 0:
                break;
        }
    }
}
