package com.netcracker.travel;

import com.netcracker.travel.controller.AuthenticationController;
import com.netcracker.travel.controller.RegistrationController;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.service.implementation.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public static void printMenu(){
        System.out.println("Hello! You are in TravelSystem! Please, choose the action number: \n 1. Watch tours \n 2. Log in \n 3. Registration \n 0. Exit");
    }

    public static void chooseAction(){
        boolean exit = false;
        while (!exit) {
            printMenu();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        UserServiceImpl userService = new UserServiceImpl();
                        System.out.println(userService.watchTours());
                        break;
                    case 2:
                        AuthenticationController authenticationController = new AuthenticationController();
                        LoginRequestDto loginRequestDto = new LoginRequestDto("User", "12345");
                        authenticationController.login(loginRequestDto);
                        break;
                    case 3:
                        RegistrationController registrationController = new RegistrationController();
                        RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto();
                        registrationController.registration(registrationRequestDto);
                        break;

                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Input 1, 2 or 3 - action and 0 - exit");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }
}
