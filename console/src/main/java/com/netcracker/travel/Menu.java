package com.netcracker.travel;

import com.netcracker.travel.controller.AuthenticationController;
import com.netcracker.travel.controller.RegistrationController;
import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class Menu {

    public static void chooseAction() {
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

                        //если аутентификация прошла успешно
                        UserConverter userConverter = new UserConverter();
                        CustomerServiceImpl customerService = new CustomerServiceImpl();
                        UserDto userDto = new UserDto();
                        // System.out.println("Hello! " + userService.getByUsername(userDto.getFirstName()));
                        try {
                            boolean exit2 = false;
                            while (!exit2) {
                                printUserMenu();
                                int y = Integer.parseInt(reader.readLine());
                                switch (y) {
                                    case 1:
                                        try {
                                            boolean exit3 = false;
                                            while (!exit3) {
                                                printUserMenuSearchTour();
                                                int z = Integer.parseInt(reader.readLine());
                                                switch (z) {
                                                    case 1:
                                                        System.out.println("Please, input the country");
                                                        customerService.searchTourByCountry(reader.readLine());
                                                        break;
                                                    case 2:
                                                        System.out.println("Please, input the start date (2000-10-10)");
                                                        Date startDate = Date.valueOf(reader.readLine());
                                                        System.out.println("And the end date");
                                                        Date endDate = Date.valueOf(reader.readLine());
                                                        customerService.searchTourByDate(startDate, endDate);
                                                        break;
                                                    case 3:
                                                        System.out.println("Please, input the name");
                                                        customerService.searchTourByName(reader.readLine());
                                                        break;
                                                    case 4:

                                                        try {
                                                            boolean exit4 = false;
                                                            while (!exit4) {
                                                                printUserTypeMenu();
                                                                int type = Integer.parseInt(reader.readLine());
                                                                switch (type) {
                                                                    case 1:
                                                                        customerService.searchTourByType(1);
                                                                        break;
                                                                    case 2:
                                                                        customerService.searchTourByType(2);
                                                                        break;
                                                                    case 3:
                                                                        customerService.searchTourByType(3);
                                                                        break;
                                                                    case 4:
                                                                        customerService.searchTourByType(4);
                                                                        break;
                                                                    case 5:
                                                                        customerService.searchTourByType(5);
                                                                        break;
                                                                    case 0:
                                                                        exit4 = true;
                                                                        break;
                                                                    default:
                                                                        printMesInput();
                                                                }
                                                            }
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Wrong input");
                                                        }

                                                    case 0:
                                                        exit3 = true;
                                                        break;
                                                    default:
                                                        printMesInput();
                                                }
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        } catch (NumberFormatException e) {
                                            System.out.println("Wrong input");
                                        }

                                        break;
                                    case 2:
                                       // customerService.bookTour();
                                        break;
                                    case 3:
                                        //customerService.buyTour();
                                        break;
                                    case 4:
                                        customerService.viewOrderedTours(userDto.getId());
                                        break;
                                    case 5:
                                      //  customerService.cancelTour();
                                        break;
                                    case 0:
                                        exit2 = true;
                                        break;
                                    default:
                                        printMesInput();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong input");
                        }

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
                        printMesInput();
                }
            } catch(IOException e){
                e.printStackTrace();
            } catch(NumberFormatException e){
                System.out.println("Wrong input");
            }
        }

    }

    public static void printMenu(){
        System.out.println("Hello! You are in TravelSystem! Please, choose the action number: \n 1. Watch tours \n 2. Log in \n 3. Registration \n 0. Exit");
    }

    public static void printUserMenu(){
        System.out.println("Choose the action number: \n 1. Search tours \n 2. Book a tour \n 3. Buy a tour \n 4. View ordered tours \n 5. Cancel a trip \n 0. Exit");
    }
    public static void printUserMenuSearchTour(){
        System.out.println("Choose search: \n 1. By country \n 2. By Date \n 3. By name \n 4. By Type \n 0. Exit");
    }

    public static void printUserTypeMenu(){
        System.out.println("Please, choose the type: \n 1. HOTELRESTTOUR \n 2.  SHOPTOUR \n 3. EXCURSION \n 4. CRUISE \n 5. SANATORIUM");
    }

    public static void printMesInput(){
        System.out.println("Input 1, 2 ... - action and 0 - exit");
    }
}
