package com.netcracker.travel.controller;

import com.netcracker.travel.dto.AdminDTO;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.TravelAgentDTO;
import com.netcracker.travel.service.implementation.AdminServiceImpl;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final AdminServiceImpl adminService;

    private final TravelAgentServiceImpl travelAgentService;

    private final CustomerServiceImpl customerService;

    @Autowired
    public UserController(AdminServiceImpl adminService, TravelAgentServiceImpl travelAgentService, CustomerServiceImpl customerService) {
        this.adminService = adminService;
        this.travelAgentService = travelAgentService;
        this.customerService = customerService;
    }

    @ApiOperation(value = "Gets all users", nickname = "UserController.getAllUsers")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Admins")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdminDTO>> getAllUsers() {
        log.info("UserController getAllUsers");
        List<AdminDTO> users = adminService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates user", nickname = "UserController.addUser")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Admin is created")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody AdminDTO adminDto) {
        try {
            log.info("UserController addUser: {}", adminDto.toString());
            String id = adminService.save(adminDto).getId();
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation User", HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Make user admin", nickname = "UserController.updateToAdmin")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Your rate is updated")})
    @PutMapping(
            value = "/admin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateToAdmin(
            @RequestBody String userId, Authentication authentication) {
        if (authentication != null) {
            if (adminService.makeAdmin(userId)) {
                return new ResponseEntity<>(
                        "User with id" + userId + "now admin!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Authorize first", HttpStatus.UNAUTHORIZED);
        }
    }

    @ApiOperation(value = "Make user TravelAgent", nickname = "UserController.updateToTravelAgent")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Your rate is updated")})
    @PutMapping(
            value = "/agent/role/{userId}",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity updateToTravelAgent(
            @PathVariable String userId, Authentication authentication) {
        if (authentication != null) {
            if (adminService.makeTravelAgent(userId)) {
                return new ResponseEntity<>(
                        "User with id" + userId + "now TravelAgent!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Authorize first", HttpStatus.UNAUTHORIZED);
        }
    }

    @ApiOperation(value = "Update User", nickname = "UserController.updateUser")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "User is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody AdminDTO adminDto) {
        try {
            log.info("UserController update user: {}", adminDto.toString());
            adminService.update(id, adminDto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation user", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update customer", nickname = "CustomerController.updateCustomer")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Customer is updated")})
    @PutMapping(value = "/customer/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customerDto) {
        log.info("CustomerController update user: {}", customerDto.toString());
        try {
            customerService.update(id, customerDto);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation customer", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update travelAgent", nickname = "TravelAgentController.updateTravelAgent")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "TravelAgent is updated")})
    @PutMapping(value = "/agent/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTravelAgent(@PathVariable("id") String id, @RequestBody TravelAgentDTO travelAgentDto) {
        log.info("TravelAgentController updateTravelAgent: {}", travelAgentDto.toString());
        try {
            travelAgentService.update(id, travelAgentDto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation travelAgent", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Get user by id", nickname = "UserController.getUser")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminDTO> getUser(@PathVariable("id") String id) {
        log.info("UserController getUser with id: {} ", id);
        AdminDTO adminDto = adminService.getById(id);
        if (adminDto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user", nickname = "UserController.deleteUser")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        log.info("UserController delete user with id: {} ", id);
        try {
            adminService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
