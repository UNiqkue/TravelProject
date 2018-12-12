package com.netcracker.travel.controller;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Gets all customers", nickname = "CustomerController.getAllCustomers")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Customers")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> tours = customerService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates customer", nickname = "CustomerController.addCustomer")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Customer is created")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCustomer(@RequestBody RegistrationRequestDto registrationRequestDto) {
        try {
            String id = customerService.registration(registrationRequestDto).getId();
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation tour", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update tour", nickname = "TourController.updateTour")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tour is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDto customerDto) {
        try {
            CustomerDto customerFromDb = customerService.getById(id);
            BeanUtils.copyProperties(customerDto, customerFromDb, "id");
            customerDto = customerService.update(customerFromDb);
            return new ResponseEntity<>(customerDto.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation tour", HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") String id) {
        CustomerDto customerDto = customerService.getById(id);
        if(customerDto == null){
            return new ResponseEntity<>(customerDto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete tour", nickname = "TourController.deleteTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
