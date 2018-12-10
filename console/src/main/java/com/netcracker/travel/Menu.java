package com.netcracker.travel;

import com.netcracker.travel.controller.AuthenticationController;
import com.netcracker.travel.controller.RegistrationController;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.service.implementation.AdminServiceImpl;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class Menu {

    private static AdminServiceImpl adminService;
    private static CustomerServiceImpl customerService;
    private static TravelAgentServiceImpl travelAgentService;
    private static AuthenticationController authenticationController;
    private static RegistrationController registrationController;

    @Autowired
    public static void setConfigMenu(AdminServiceImpl adminService, CustomerServiceImpl customerService, TravelAgentServiceImpl travelAgentService, AuthenticationController authenticationController, RegistrationController registrationController) {
        Menu.adminService = adminService;
        Menu.customerService = customerService;
        Menu.travelAgentService = travelAgentService;
        Menu.authenticationController = authenticationController;
        Menu.registrationController = registrationController;
    }

    public static void chooseAction() {
        BufferedReader reader = getBufferedReader();
        boolean exit = false;
        while (!exit) {
            printMenu();
            try {
                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        printTours(adminService.watchTours());
                        break;
                    case 2:
                        authenticationController.login();
                        break;
                    case 3:
                        registrationController.registration();
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
        boolean exit1 = false;
        while (!exit1) {
            try {
                printAdminMenu();

                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        printCustomers(customerService.getAll());
                        break;
                    case 2:
                        updateCustomerInformation();
                        break;
                    case 0:
                        exit1 = true;
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

    private static void updateCustomerInformation() {
        BufferedReader reader = getBufferedReader();
        String username;
        boolean exit2 = false;
        while (!exit2) {
            try {
                System.out.println("Input customer username");
                username = reader.readLine();
                boolean exit3 = false;
                while (!exit3) {
                    try {
                        String phoneNumber0 = "";
                        boolean exit5 = false;
                        while (!exit5) {
                            System.out.println("You can change phoneNumber");
                            phoneNumber0 = reader.readLine();
                            try {
                                customerService.verifyPhoneNumber(phoneNumber0);
                                exit5 = true;
                            } catch (PhoneNumberException e) {
                                System.out.println("Invalid phone number. Example: +375/80-29-234-43-34");
                            }

                        }
                        String phoneNumber = phoneNumber0;
                        customerService.updatePhoneNumber(username, phoneNumber);
                        exit3 = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                exit2 = true;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e) {
                System.out.println("User is not found");
            }
        }
    }


    public static void travelAgentConsole(String username) {
        BufferedReader reader = getBufferedReader();
        TravelAgentDto travelAgentDto = travelAgentService.getByUsername(username);
        boolean exit1 = false;
        while (!exit1) {
            try {
                printTravelAgentMenu();

                int x = Integer.parseInt(reader.readLine());
                switch (x) {
                    case 1:
                        printTours(travelAgentService.watchTours());
                        break;
                    case 2:
                        updateTours(travelAgentDto);
                        break;
                    case 3:
                        printTours(travelAgentService.getExistenceTours());
                        break;
                    case 4:
                        makeDiscount();
                        break;
                    case 0:
                        exit1 = true;
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

    private static void updateTours(TravelAgentDto travelAgentDto) {
        BufferedReader reader = getBufferedReader();
        boolean exit = false;
        while (!exit) {
            try {
                printTravelAgentUpdateTour();
                int type = Integer.parseInt(reader.readLine());
                switch (type) {
                    case 1:
                        createTour(travelAgentDto);
                        break;
                    case 2:
                        updateTourDescription();
                        break;
                    case 3:
                        deleteTour();
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

    private static void createTour(TravelAgentDto travelAgentDto) {
        BufferedReader reader = getBufferedReader();
        TourDto tourDto = new TourDto();
        while (!tourDto.isFree()) {
            try {
                System.out.println("Input the name");
                tourDto.setName(reader.readLine());
                System.out.println("Please, input the description");
                tourDto.setDescription(reader.readLine());
                while (tourDto.getPrice() == null) {
                    try {
                        System.out.println("Please, input the price");
                        tourDto.setPrice(Double.valueOf(reader.readLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Example: 289.90");
                    }
                }
                System.out.println("Please, input country");
                tourDto.setCountry(reader.readLine());
                boolean exitcreate1 = false;
                while (!exitcreate1) {
                    try {
                        System.out.println("Please, input the type (HOTELRESTTOUR, SHOPTOUR, EXCURSION, CRUISE, SANATORIUM)");
                        tourDto.setType(reader.readLine());
                        exitcreate1 = true;
                    } catch (IOException e) {
                        System.out.println("No such type");
                    } catch (IllegalArgumentException e) {
                        System.out.println("No such type");
                    }

                }
                boolean exitcreate = false;
                while (!exitcreate) {
                    try {
                        System.out.println("Please, input the startDate");
                        tourDto.setStartDate(Date.valueOf(reader.readLine()));
                        System.out.println("Please, input the endDate");
                        tourDto.setEndDate(Date.valueOf(reader.readLine()));
                    } catch (IllegalArgumentException e) {
                        System.out.println("You input not corrected date. Example: 2000-10-10");
                    }
                    if (tourDto.getStartDate() != null && tourDto.getEndDate() != null) {
                        exitcreate = true;
                    }
                }
                tourDto.setTravelAgency(travelAgentDto.getTravelAgency());
                tourDto.setFree(true);
            } catch (IOException e) {
                System.out.println("No such type");
            } catch (IllegalArgumentException e) {
                System.out.println("No such type");
            }

        }
        travelAgentService.createTour(tourDto);
        System.out.println("You create tour \n");
        printTours(travelAgentService.getExistenceTours());
    }

    private static void updateTourDescription() throws IOException {
        BufferedReader reader = getBufferedReader();
        String tourId = "00000000-0000-0000-0000-000000000000";
        UUID tourUid = UUID.fromString(tourId);
        tourUid = inputTourUid(tourId, tourUid);
        System.out.println("Input description");
        String description = reader.readLine();
        travelAgentService.editTour(tourUid, description);
    }

    private static void deleteTour() {
        String tourId = "00000000-0000-0000-0000-000000000000";
        UUID tourUid = UUID.fromString(tourId);
        tourUid = inputTourUid(tourId, tourUid);
        travelAgentService.deleteTour(tourUid);
    }

    private static void makeDiscount() throws IOException {
        BufferedReader reader = getBufferedReader();
        String tourId = "00000000-0000-0000-0000-000000000000";
        UUID tourUid = UUID.fromString(tourId);
        tourUid = inputTourUid(tourId, tourUid);
        Double price = 0.0;
        while (price == 0.0) {
            try {
                System.out.println("Please, input the price");
                price = Double.valueOf(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Example: 289.90");
            }
        }
        travelAgentService.makeDiscount(tourUid, price);
    }

    public static void customerConsole(String username) {
        BufferedReader reader = getBufferedReader();
        CustomerDto customerDto = customerService.getByUsername(username);
        boolean exit = false;
        while (!exit) {
            try {
                printUserMenu();
                int y = Integer.parseInt(reader.readLine());
                switch (y) {
                    case 1:
                        searchTours();
                        break;
                    case 2:
                        buyTour(customerDto);
                        break;
                    case 3:
                        printTours(customerService.watchTours(customerDto.getId()));
                        break;
                    case 4:
                        cancelTour(customerDto);
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

    private static void searchTours() {
        BufferedReader reader = getBufferedReader();
        boolean exit3 = false;
        while (!exit3) {
            try {
                printUserMenuSearchTour();
                int z = Integer.parseInt(reader.readLine());
                switch (z) {
                    case 1:
                        System.out.println("Input the country ");
                        printTours(customerService.searchTourByCountry(reader.readLine()));
                        break;
                    case 2:
                        searchToursByDate();
                        break;
                    case 3:
                        System.out.println("Please, input the name");
                        printTours(customerService.searchTourByName(reader.readLine()));
                        break;
                    case 4:
                        searchToursByType();
                        break;
                    case 5:
                        searchToursByTravelAgencyName();
                        break;
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
    }

    private static void searchToursByTravelAgencyName() {
        BufferedReader reader = getBufferedReader();
        try {
            System.out.println("Please, input the TravelAgency name");
            printTours(customerService.searchTourByTravelAgency(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("TravelAgency is not found.");
        }
    }

    private static void searchToursByType() {
        BufferedReader reader = getBufferedReader();
        boolean exit4 = false;
        while (!exit4) {
            try {
                printUserTypeMenu();
                int type = Integer.parseInt(reader.readLine());
                switch (type) {
                    case 1:
                        printTours(customerService.searchTourByType("HOTELRESTTOUR"));
                        break;
                    case 2:
                        printTours(customerService.searchTourByType("SHOPTOUR"));
                        break;
                    case 3:
                        printTours(customerService.searchTourByType("EXCURSION"));
                        break;
                    case 4:
                        printTours(customerService.searchTourByType("CRUISE"));
                        break;
                    case 5:
                        printTours(customerService.searchTourByType("SANATORIUM"));
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
    }

    private static void searchToursByDate() throws IOException {
        BufferedReader reader = getBufferedReader();
        boolean exit = false;
        Date startDate = Date.valueOf("2100-10-10");
        Date endDate = Date.valueOf("2100-10-10");
        while (!exit) {
            try {
                System.out.println("Please, input the start date (2000-10-10)");
                startDate = Date.valueOf(reader.readLine());
                printTours(customerService.searchTourByStartDate(startDate));
                System.out.println("And the end date");
                endDate = Date.valueOf(reader.readLine());
                printTours(customerService.searchTourByEndDate(endDate));
            } catch (IllegalArgumentException e) {
                System.out.println("You input not corrected date. Example: 2000-10-10");
            }
            if ((startDate != Date.valueOf("2100-10-10")) && (endDate != Date.valueOf("2100-10-10"))) {
                exit = true;
            }
        }
    }

    private static void buyTour(CustomerDto customerDto) {
        String tourId = "00000000-0000-0000-0000-000000000000";
        UUID tourUid = UUID.fromString(tourId);
        tourUid = inputTourUid(tourId, tourUid);
        customerService.buyTour(tourUid, customerDto.getId());
    }

    private static void cancelTour(CustomerDto customerDto) {
        String tourId = "00000000-0000-0000-0000-000000000000";
        UUID tourUid = UUID.fromString(tourId);
        tourUid = inputTourUid(tourId, tourUid);
        customerService.cancelTour(tourUid, customerDto.getId());
    }

    private static void printTours(List<TourDto> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(i + 1 + " " + list.get(i));
    }


    private static void printCustomers(List<CustomerDto> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(i + 1 + " " + list.get(i));
    }

    private static UUID inputTourUid(String tourId, UUID tourUid) {
        BufferedReader reader = getBufferedReader();
        boolean exit = false;
        while (!exit) {
            System.out.println("Input tour id");
            try {
                tourUid = UUID.fromString(reader.readLine());
                tourId = tourUid.toString();

            } catch (IOException e) {
                System.out.println("Not corrected id");
            } catch (IllegalArgumentException e) {
                System.out.println("Not corrected id");
            }
            exit = !tourId.equals("00000000-0000-0000-0000-000000000000");
        }
        return tourUid;
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static void printMenu() {
        System.out.println("Hello! You are in TravelSystem! Please, choose the action number: \n 1. Watch tours \n 2. Log in \n 3. Registration \n 0. Exit");
    }

    private static void printUserMenu() {
        System.out.println("Choose the action number: \n 1. Search tours \n 2. Buy a tour \n 3. View ordered tours \n 4. Cancel a trip \n 0 - Log out");
    }

    private static void printUserMenuSearchTour() {
        System.out.println("Choose search: \n 1. By country \n 2. By Date \n 3. By name \n 4. By Type \n 5. By TravelAgency \n 0. Exit");
    }

    private static void printUserTypeMenu() {
        System.out.println("Please, choose the type: \n 1. HOTELRESTTOUR \n 2. SHOPTOUR \n 3. EXCURSION \n 4. CRUISE \n 5. SANATORIUM \n 0. Exit");
    }

    public static void printMesInput() {
        System.out.println("Input 1, 2 ... - action and 0 - exit");
    }

    private static void printAdminMenu() {
        System.out.println("Admin, choose number: \n 1. Watch customers \n 2. Update customer information \n 0 - Log out");
    }

    private static void printTravelAgentMenu() {
        System.out.println("TravelAgent, choose number: \n 1. View history of orders \n 2. Edit tour \n 3. Check all tours \n 4. Make a discount (last minute tour) \n 0 - Log out");
    }

    private static void printTravelAgentUpdateTour() {
        System.out.println("Input action number: \n 1. Create tour \n 2. Update tour \n 3. Delete tour \n 0 - exit");
    }

}
