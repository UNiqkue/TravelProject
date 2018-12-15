package com.netcracker.travel.controller;

import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.RegistrationRequestDTO;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.RegistrationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    private final RegistrationServiceImpl registrationService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService, RegistrationServiceImpl registrationService) {
        this.customerService = customerService;
        this.registrationService = registrationService;
    }

    @ApiOperation(value = "Gets all customers", nickname = "CustomerController.getAllCustomers")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Customers")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        log.info("CustomerController getAllCustomers");
        List<CustomerDTO> tours = customerService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates customer", nickname = "CustomerController.addCustomer")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Customer is created")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCustomer(@RequestBody RegistrationRequestDTO registrationRequestDto) {
        log.info("CustomerController addCustomer: {}", registrationRequestDto.toString());
        try {
            String id = registrationService.registration(registrationRequestDto).getId();
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation customer", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update customer", nickname = "CustomerController.updateCustomer")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Customer is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customerDto) {
        log.info("CustomerController update user: {}", customerDto.toString());
        try {
            customerDto.setId(id);
            customerDto = customerService.update(customerDto);
            return new ResponseEntity<>(customerDto.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation customer", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Gets specific customer", nickname = "CustomerController.getCustomer")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Customer")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") String id) {
        log.info("CustomerController getCustomer by id: {} ", id);
        CustomerDTO customerDto = customerService.getById(id);
        if(customerDto == null){
            return new ResponseEntity<>(customerDto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete customer", nickname = "CustomerController.deleteCustomer")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Customer is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id) {
        log.info("CustomerController delete user by id: {} ", id);
        try {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
