package com.netcracker.travel.service.implementation;

import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.AuthenticationService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CustomerServiceImpl customerServiceImpl;
   
    private final AdminServiceImpl adminServiceImpl;
   
    private final TravelAgentServiceImpl travelAgentServiceImpl;
   
    private final AuthenticationManager authenticationManager;
 
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthenticationServiceImpl(CustomerServiceImpl customerServiceImpl, AdminServiceImpl adminServiceImpl, TravelAgentServiceImpl travelAgentServiceImpl, AuthenticationManager authenticationManager) {
        this.customerServiceImpl = customerServiceImpl;
        this.adminServiceImpl = adminServiceImpl;
        this.travelAgentServiceImpl = travelAgentServiceImpl;
        this.authenticationManager = authenticationManager;
    }

    public CustomerDto loginCustomer(@NonNull LoginRequestDto loginRequestDto) {
//        bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        if (customerServiceImpl.getByName(loginRequestDto.getUsername()) == null) {
//            return null;
//        } else {
//            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), customerServiceImpl.getByName(loginRequestDto.getUsername()).getPassword())) {
//                return customerServiceImpl.getByName(loginRequestDto.getUsername());
//            } else {
                return null;
//           }
//        }
    }

    public AdminDto loginAdmin(@NonNull LoginRequestDto loginRequestDto) {
//        bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        if (adminServiceImpl.getByName(loginRequestDto.getUsername()) == null) {
//            return null;
//        } else {
//            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), adminServiceImpl.getByName(loginRequestDto.getUsername()).getPassword())) {
//                return adminServiceImpl.getByName(loginRequestDto.getUsername());
//            } else {
                return null;
//            }
//        }
    }

    public TravelAgentDto loginTravelAgent(@NonNull LoginRequestDto loginRequestDto) {
//        bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        if (travelAgentServiceImpl.getByName(loginRequestDto.getUsername()) == null) {
//            return null;
//        } else {
//            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), travelAgentServiceImpl.getByName(loginRequestDto.getUsername()).getPassword())) {
//                return travelAgentServiceImpl.getByName(loginRequestDto.getUsername());
//            } else {
                return null;
//            }
//        }
    }


}
