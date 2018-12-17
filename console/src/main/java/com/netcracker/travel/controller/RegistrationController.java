package com.netcracker.travel.controller;

import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.RegistrationRequestDTO;
import com.netcracker.travel.service.implementation.RegistrationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class RegistrationController {

    private PasswordEncoder passwordEncoder;

    private RegistrationServiceImpl registrationService;

    @Autowired
    public RegistrationController(RegistrationServiceImpl registrationService, PasswordEncoder passwordEncoder) {
        this.registrationService = registrationService;
        this.passwordEncoder = passwordEncoder;
    }

    @ApiOperation(value = "Add user", nickname = "RegistrationController.addUser")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User")})
    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> addUser(RegistrationRequestDTO registrationRequestDTO) {
        registrationRequestDTO.setPassword(passwordEncoder.encode(registrationRequestDTO.getPassword()));
        CustomerDTO customerDTO = registrationService.registration(registrationRequestDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
}
