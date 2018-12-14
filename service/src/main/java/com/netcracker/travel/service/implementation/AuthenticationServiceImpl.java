package com.netcracker.travel.service.implementation;

import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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

//    public LoginResponseDto login(final LoginRequestDto loginRequestDto) {
//        try {
//            String username = Optional.ofNullable(loginRequestDto.getUsername())
//                    .orElseThrow(() -> new BadCredentialsException("Username should be passed."));
//            String password = Optional.ofNullable(loginRequestDto.getPassword())
//                    .orElseThrow(() -> new BadCredentialsException("Password should be passed."));
//            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
//                    password);
//
//            // Try to authenticate with this token
//            final Authentication authResult = this.authenticationManager.authenticate(authRequest);
//
//            // Set generated JWT token to response header
//            if (authResult.isAuthenticated()) {
//                UserDetails userDetails = (UserDetails) authResult.getPrincipal();
//                CustomerDto user = customerServiceImpl.findOne(userDetails.getId());
//                if (Objects.isNull(user)) {
//                    throw new RuntimeException("User not exist in system.");
//                }
//
//                if(user.isBanned()){
//                    throw new RuntimeException("User is banned");
//                }
//
//                if(!user.isEnabled()){
//                    throw new RuntimeException("Confirm email pls");
//                }
//
//                String token = this.authenticationHelper.generateToken(userDetails);
//                if (user.getAlias() == null) {
//                    user.setAlias("user"+user.getUsername());
//                    return new LoginResponseDto(token, user.getAlias());
//                } else {
//                    return new LoginResponseDto(token, user.getAlias());
//                }
//            } else {
//                throw new RuntimeException("Authentication failed.");
//            }
//
//        } catch (BadCredentialsException exception) {
//            throw new RuntimeException("Username or password was incorrect. Please try again.", exception);
//        }
//    }

    @Transactional
    public CustomerDto loginCustomer(LoginRequestDto loginRequestDto) {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (customerServiceImpl.getByName(loginRequestDto.getUsername()) == null) {
            return null;
        } else {
            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), customerServiceImpl.getByName(loginRequestDto.getUsername()).getPassword())) {
                return customerServiceImpl.getByName(loginRequestDto.getUsername());
            } else {
                return null;
           }
        }
    }

    @Transactional
    public AdminDto loginAdmin(LoginRequestDto loginRequestDto) {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (adminServiceImpl.getByName(loginRequestDto.getUsername()) == null) {
            return null;
        } else {
            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), adminServiceImpl.getByName(loginRequestDto.getUsername()).getPassword())) {
                return adminServiceImpl.getByName(loginRequestDto.getUsername());
            } else {
                return null;
//            }
            }
        }
    }

    @Transactional
    public TravelAgentDto loginTravelAgent(LoginRequestDto loginRequestDto) {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (travelAgentServiceImpl.getByName(loginRequestDto.getUsername()) == null) {
            return null;
        } else {
            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), travelAgentServiceImpl.getByName(loginRequestDto.getUsername()).getPassword())) {
                return travelAgentServiceImpl.getByName(loginRequestDto.getUsername());
            } else {
                return null;
            }
        }
    }

    private void printErrorLogin(){
        System.out.println("You input not corrected username");
    }


}
