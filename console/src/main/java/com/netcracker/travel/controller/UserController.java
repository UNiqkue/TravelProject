package com.netcracker.travel.controller;

import com.netcracker.travel.dto.AdminDTO;
import com.netcracker.travel.service.implementation.AdminServiceImpl;
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

    @Autowired
    public UserController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @ApiOperation(value = "Gets all users", nickname = "UserController.getAllUsers")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Admins")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdminDTO>> getAllUsers() {
        log.info("UserController getAllUsers");
        List<AdminDTO> users = adminService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
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

    @ApiOperation(value = "Creates user", nickname = "UserController.addUser")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Admin is created")})
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody AdminDTO adminDto) {
        try {
            log.info("UserController addUser: {}", adminDto.toString());
            String id = adminService.save(adminDto).getId();
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation User", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Make user Admin", nickname = "UserController.updateToAdmin")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Your rate is updated")})
    @PutMapping(
            value = "/role/admin/{userId}",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> updateToAdmin(
            @PathVariable String userId, Authentication authentication) {
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
            value = "/role/agent/{userId}",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
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
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody AdminDTO adminDto) {
        try {
            log.info("UserController update user: {}", adminDto.toString());
            adminService.update(id, adminDto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation user", HttpStatus.BAD_REQUEST);
        }
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
