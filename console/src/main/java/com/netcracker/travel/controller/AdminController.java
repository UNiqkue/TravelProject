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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@Slf4j
@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminServiceImpl adminService;

    @Autowired
    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @ApiOperation(value = "Gets all admins", nickname = "AdminController.getAllAdmins")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Admins")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        log.info("AdminController getAllAdmins");
        List<AdminDTO> tours = adminService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

//    @ApiOperation(value = "Creates admin", nickname = "AdminController.addAdmin")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "Admin is created")})
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> addAdmin(@RequestBody AdminDTO adminDto) {
//        try {
//            log.info("AdminController addAdmin: {}", adminDto.toString());
//            String id = adminService.save(adminDto).getId();
//            return new ResponseEntity<>(id, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error in creation Admin", HttpStatus.BAD_REQUEST);
//        }
//    }

    @ApiOperation(value = "Update Admin", nickname = "AdminController.updateAdmin")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Admin is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAdmin(@PathVariable("id") String id, @RequestBody AdminDTO adminDto) {
        try {
            log.info("AdminController update admin: {}", adminDto.toString());
            adminService.update(id, adminDto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation admin", HttpStatus.BAD_REQUEST);
        }
    }
    
    @ApiOperation(value = "Gets specific admin", nickname = "AdminController.getAdmin")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Admin")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable("id") String id) {
        log.info("AdminController getAdmin with id: {} ", id);
        AdminDTO adminDto = adminService.getById(id);
        if(adminDto == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete admin", nickname = "AdminController.deleteAdmin")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Admin is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") String id) {
        log.info("AdminController delete admin with id: {} ", id);
        try {
            adminService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
