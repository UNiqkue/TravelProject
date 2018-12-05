package com.netcracker.travel.controller;

import com.netcracker.travel.Menu;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.service.implementation.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private LoginRequestDto loginRequestDto;

    public void login() {
        boolean exit = false;
        while (!exit) {
            printWindow();
            try {
                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        requestCustomer();
                        break;
                    case 2:
                        requestTravelAgent();
                        break;
                    case 3:
                        requestAdmin();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        Menu.printMesInput();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void requestAdmin() {
        try {
            loginRequestDto = inputLoginRequest();
            if (authenticationService.loginAdmin(loginRequestDto)) {
                Menu.adminConsole();
            } else {
                printRequestError();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void requestTravelAgent() {
        try {
            loginRequestDto = inputLoginRequest();
            if (authenticationService.loginTravelAgent(loginRequestDto)) {
                Menu.travelAgentConsole(loginRequestDto.getUsername());
            } else {
                printRequestError();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void requestCustomer() {
        try {
            loginRequestDto = inputLoginRequest();
            if (authenticationService.loginCustomer(loginRequestDto)) {
                Menu.customerConsole(loginRequestDto.getUsername());
            } else {
                printRequestError();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String inputUsername() throws IOException {
        System.out.println("Please, input the username:");
        String username = reader.readLine();
        return username;
    }

    private String inputPassword() throws IOException {
        System.out.println("Please, input the password:");
        String password = reader.readLine();
        return password;
    }

    private LoginRequestDto inputLoginRequest() throws IOException {
        String username = inputUsername();
        String password = inputPassword();
        loginRequestDto = new LoginRequestDto(username, password);
        return loginRequestDto;
    }

    private void printWindow() {
        System.out.println("You registered by? \n 1. Customer \n 2. TravelAgent \n 3. Admin \n 0. Exit");
    }

    private void printRequestError() {
        System.out.println("You input not corrected password");
    }


}