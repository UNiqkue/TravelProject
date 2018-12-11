package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.repository.AdminRepository;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.repository.TravelAgentRepository;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TravelAgentRepository travelAgentRepository;

    @Autowired
    private AdminConverter adminConverter;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private TravelAgentConverter travelAgentConverter;

    public AuthenticationServiceImpl() {
    }
    public boolean loginCustomer(LoginRequestDto loginRequestDto){
       /* try {
            CustomerDto customerDto = customerConverter.convert(customerRepository.findByUsername(loginRequestDto.getUsername()));
            if (customerDto.getPassword().equals(loginRequestDto.getPassword())) {
                return true;
            }
        } catch (NullPointerException e) {
            printErrorLogin();
        }*/
        return false;
    }

    public boolean loginAdmin(LoginRequestDto loginRequestDto){
       /* try {
            AdminDto adminDto = adminConverter.convert(adminRepository.findByUsername(loginRequestDto.getUsername()));
            if (adminDto.getPassword().equals(loginRequestDto.getPassword())) {
                return true;
            }
        } catch (NullPointerException e) {
            printErrorLogin();
        }*/
        return false;
    }

    public boolean loginTravelAgent(LoginRequestDto loginRequestDto){
      /*  try {
            TravelAgentDto travelAgentDto = travelAgentConverter.convert(travelAgentRepository.findByUsername(loginRequestDto.getUsername()));
            if (travelAgentDto.getPassword().equals(loginRequestDto.getPassword())) {
                return true;
            }
        } catch (NullPointerException e) {
            printErrorLogin();
        }*/
        return false;
    }

    private void printErrorLogin(){
        System.out.println("You input not corrected username");
    }


}
