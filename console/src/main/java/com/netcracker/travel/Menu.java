package com.netcracker.travel;

import com.netcracker.travel.controller.AuthenticationController;
import com.netcracker.travel.controller.RegistrationController;
import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.service.implementation.AdminServiceImpl;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.UUID;

public class Menu {

    public static void chooseAction() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            BufferedReader reader = getBufferedReader();
            try {
                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        AdminServiceImpl adminService = new AdminServiceImpl();
                        System.out.println(adminService.watchTours());
                        break;
                    case 2:
                        AuthenticationController authenticationController = new AuthenticationController();
                        authenticationController.login();
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
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }

    public static void adminConsole() {
        BufferedReader reader = getBufferedReader();
        AdminServiceImpl adminService = new AdminServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        try {
            printAdminMenu();
            boolean exit1 = false;
            while (!exit1) {
                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        customerService.getAll();
                        break;
                    case 2:
                        String username = "";
                        boolean exit2 = false;
                        while (!exit2) {
                            try {
                                System.out.println("Input customer username");
                                username = reader.readLine();
                                boolean exit3 = false;
                                while (!exit3) {
                                    try {
                                        System.out.println("You can change phoneNumber");
                                        String phoneNumber = reader.readLine();
                                        customerService.updatePhoneNumber(username, phoneNumber);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (NumberFormatException e) {
                                        System.out.println("Wrong input");
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong input");
                            }
                        }
                        break;
                    case 0:
                        exit1 = true;
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
    }

    public static void travelAgentConsole() {
        BufferedReader reader = getBufferedReader();
        TravelAgentServiceImpl travelAgentService = new TravelAgentServiceImpl();
        try {
            printTravelAgentMenu();
            boolean exit1 = false;
            while (!exit1) {
                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        travelAgentService.viewOrderHystory();
                        break;
                    case 2:
                        boolean exit4 = false;
                        while (!exit4) {
                            try {
                                printTravelAgentUpdateTour();
                                int type = Integer.parseInt(reader.readLine());
                                switch (type) {
                                    case 1:
                                        travelAgentService.createTour();
                                        break;
                                    case 2:
                                        System.out.println("Input tourId");
                                        UUID id1 = UUID.fromString(reader.readLine());
                                        travelAgentService.editTour(id1);
                                        break;
                                    case 3:
                                        System.out.println("Input tourId");
                                        UUID id2 = UUID.fromString(reader.readLine());
                                        travelAgentService.deleteTour(id2);
                                        break;
                                    case 0:
                                        exit4 = true;
                                        break;
                                    default:
                                        printMesInput();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong input");
                            }
                        }


                        break;
                    case 3:
                        travelAgentService.checkExistenceTours();
                        break;
                    case 4:
                        travelAgentService.makeDiscount();
                        break;
                    case 0:
                        exit1 = true;
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
    }

    public static void customerConsole() {
        BufferedReader reader = getBufferedReader();
        AdminConverter adminConverter = new AdminConverter();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        AdminDto adminDto = new AdminDto();
        try {
            boolean exit2 = false;
            while (!exit2) {
                printUserMenu();
                int y = Integer.parseInt(reader.readLine());
                switch (y) {
                    case 1:

                        boolean exit3 = false;
                        while (!exit3) {
                            try {
                                printUserMenuSearchTour();
                                int z = Integer.parseInt(reader.readLine());
                                switch (z) {
                                    case 1:
                                        System.out.println("Please, input the country");
                                        customerService.searchTourByCountry(reader.readLine());
                                        break;
                                    case 2:
                                        /******************Exception IllegalArgumentException*************************/

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


                                        boolean exit4 = false;
                                        while (!exit4) {
                                            try {
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
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } catch (NumberFormatException e) {
                                                System.out.println("Wrong input");
                                            }
                                        }

                                    case 0:
                                        exit3 = true;
                                        break;
                                    default:
                                        printMesInput();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong input");
                            }
                        }

                        break;
                    case 2:
                        // customerService.bookTour();
                        break;
                    case 3:
                        //customerService.buyTour();
                        break;
                    case 4:
                        customerService.viewOrderedTours(adminDto.getId());
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

    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void printMenu() {
        System.out.println("Hello! You are in TravelSystem! Please, choose the action number: \n 1. Watch tours \n 2. Log in \n 3. Registration \n 0. Exit");
    }

    public static void printUserMenu() {
        System.out.println("Choose the action number: \n 1. Search tours \n 2. Book a tour \n 3. Buy a tour \n 4. View ordered tours \n 5. Cancel a trip \n 0 - Log out");
    }

    public static void printUserMenuSearchTour() {
        System.out.println("Choose search: \n 1. By country \n 2. By Date \n 3. By name \n 4. By Type \n 0. Exit");
    }

    public static void printUserTypeMenu() {
        System.out.println("Please, choose the type: \n 1. HOTELRESTTOUR \n 2. SHOPTOUR \n 3. EXCURSION \n 4. CRUISE \n 5. SANATORIUM \n 0. Exit");
    }

    public static void printMesInput() {
        System.out.println("Input 1, 2 ... - action and 0 - exit");
    }

    public static void printAdminMenu() {
        System.out.println("Admin, choose number: \n 1. Watch customers \n 2. Update customer information \n 0 - Log out");
    }

    private static void printTravelAgentMenu() {
        System.out.println("TravelAgent, choose number: \n 1. View history of orders \n 2. Edit tour \n 3. Check all tours \n 4. Make a discount to regular customers \n 0 - Log out");
    }

    private static void printTravelAgentUpdateTour() {
        System.out.println("Input action number: \n 1. Create tour \n 2. Update tour \n 3. Delete tour \n 0 - exit");
    }

}
