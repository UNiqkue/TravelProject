package com.netcracker.travel.controller;

import com.netcracker.travel.service.implementation.AuthenticationServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RestController
@RequestMapping
public class AuthenticationController {

    private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthenticationServiceImpl authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

//    @ApiOperation(value = "Login Customer", nickname = "AuthenticationController.addCustomer")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Good")})
//    @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//    public ResponseEntity<CustomerDto> addCustomer(@RequestBody LoginRequestDto loginRequestDto) {
//        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
//        authenticationService.loginCustomer(loginRequestDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Login Admin", nickname = "AuthenticationController.addAdmin")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Good")})
//    @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//    public ResponseEntity<AdminDto> addAdmin(@RequestBody LoginRequestDto loginRequestDto) {
//        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
//        authenticationService.loginAdmin(loginRequestDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Login TravelAgent", nickname = "AuthenticationController.addTravelAgent")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Good")})
//    @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//    public ResponseEntity<TravelAgentDto> addTravelAgent(@RequestBody LoginRequestDto loginRequestDto) {
//        System.out.println(loginRequestDto.getPassword() + " " + loginRequestDto.getUsername());
//        authenticationService.loginTravelAgent(loginRequestDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}