package com.netcracker.travel.controller;

import com.netcracker.travel.Menu;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.service.implementation.AuthenticationServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthenticationController {

    public void login() {
        AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int buf = 10;
        while (buf == 10) {
            try {
                System.out.println("Please, input the username:");
                String username = reader.readLine();

                System.out.println("Please, input the password:");
                String password = reader.readLine();

                LoginRequestDto loginRequestDto = new LoginRequestDto(username, password);

                buf = authenticationService.login(loginRequestDto);

                switch (buf) {
                    case 1:
                        Menu.adminConsole();
                        break;
                    case 2:
                        Menu.customerConsole(loginRequestDto.getUsername());
                        break;
                    case 3:
                        Menu.travelAgentConsole();
                        break;
                    default:
                        System.out.println("You input not corrected password");
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
