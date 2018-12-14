package com.netcracker.travel.controller;

import com.netcracker.travel.service.implementation.AuthenticationServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

//    @ApiOperation(value = "Login Customer", nickname = "AuthenticationController.addCustomer")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Good")})
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public CustomerDto addCustomer(@RequestBody LoginRequestDto loginRequestDto) {
//        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
//        return authenticationService.loginCustomer(loginRequestDto);
//    }
//
//    @ApiOperation(value = "Login Admin", nickname = "AuthenticationController.addAdmin")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Good")})
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public AdminDto addAdmin(@RequestBody LoginRequestDto loginRequestDto) {
//        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
//        return authenticationService.loginAdmin(loginRequestDto);
//    }
//
//    @ApiOperation(value = "Login TravelAgent", nickname = "AuthenticationController.addTravelAgent")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Good")})
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public TravelAgentDto addTravelAgent(@RequestBody LoginRequestDto loginRequestDto) {
//        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
//        return authenticationService.loginTravelAgent(loginRequestDto);
//    }

}