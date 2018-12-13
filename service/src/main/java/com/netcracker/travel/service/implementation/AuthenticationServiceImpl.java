package com.netcracker.travel.service.implementation;

import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CustomerServiceImpl customerServiceImpl;
    private final AdminServiceImpl adminServiceImpl;
    private final TravelAgentServiceImpl travelAgentServiceImpl;
 //   private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthenticationServiceImpl(CustomerServiceImpl customerServiceImpl, AdminServiceImpl adminServiceImpl, TravelAgentServiceImpl travelAgentServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
        this.adminServiceImpl = adminServiceImpl;
        this.travelAgentServiceImpl = travelAgentServiceImpl;
    }

    @Transactional
    public CustomerDto loginCustomer(LoginRequestDto loginRequestDto) {
  //      bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (customerServiceImpl.getByUsername(loginRequestDto.getUsername()) == null) {
            return null;
        } else {
//            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), customerServiceImpl.getByUsername(loginRequestDto.getUsername()).getPassword())) {
//                return customerServiceImpl.getByUsername(loginRequestDto.getUsername());
//            } else {
                return null;
          //  }
        }
    }

    @Transactional
    public AdminDto loginAdmin(LoginRequestDto loginRequestDto) {
    //    bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (adminServiceImpl.getByUsername(loginRequestDto.getUsername()) == null) {
            return null;
        } else {
//            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), adminServiceImpl.getByUsername(loginRequestDto.getUsername()).getPassword())) {
//                return adminServiceImpl.getByUsername(loginRequestDto.getUsername());
//            } else {
                return null;
//            }
        }
    }

    @Transactional
    public TravelAgentDto loginTravelAgent(LoginRequestDto loginRequestDto) {
//        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (travelAgentServiceImpl.getByUsername(loginRequestDto.getUsername()) == null) {
            return null;
        } else {
//            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), travelAgentServiceImpl.getByUsername(loginRequestDto.getUsername()).getPassword())) {
//                return travelAgentServiceImpl.getByUsername(loginRequestDto.getUsername());
//            } else {
                return null;
//            }
        }
    }

    private void printErrorLogin(){
        System.out.println("You input not corrected username");
    }


}
