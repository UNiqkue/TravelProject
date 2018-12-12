package com.netcracker.travel.controller;

import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.service.implementation.TravelAgencyServiceImpl;
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
@RequestMapping("/agency")
public class TravelAgencyController {

    private final TravelAgencyServiceImpl travelAgencyService;

    @Autowired
    public TravelAgencyController(TravelAgencyServiceImpl travelAgencyService) {
        this.travelAgencyService = travelAgencyService;
    }

    @ApiOperation(value = "Gets all travelAgencies", nickname = "TravelAgencyController.getAllTravelAgencies")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "TravelAgencies")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TravelAgencyDto>> getAllTravelAgencys() {
        List<TravelAgencyDto> travelAgencies = travelAgencyService.getAll();
        return new ResponseEntity<>(travelAgencies, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates travelAgency", nickname = "TravelAgencyController.addTravelAgency")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "TravelAgency is created")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTravelAgency(@RequestBody TravelAgencyDto travelAgencyDto) {
        try {
            String id = travelAgencyService.add(travelAgencyDto).getId();
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation travelAgency", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update travelAgency", nickname = "TravelAgencyController.updateTravelAgency")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "TravelAgency is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTravelAgency(@PathVariable("id") String id, @RequestBody TravelAgencyDto travelAgencyDto) {
        try {
            TravelAgencyDto travelAgencyDtoToChange = travelAgencyService.getById(id);
            // todo rewrite to mapstruct
            BeanUtils.copyProperties(travelAgencyDto, travelAgencyDtoToChange, "id");
            travelAgencyDto = travelAgencyService.update(travelAgencyDtoToChange);
            return new ResponseEntity<>(travelAgencyDto.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation travelAgency", HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Gets specific travelAgency", nickname = "TravelAgencyController.getTravelAgency")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "TravelAgency")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TravelAgencyDto> getTravelAgency(@PathVariable("id") String id) {
        TravelAgencyDto travelAgency = travelAgencyService.getById(id);
        if(travelAgency == null){
            return new ResponseEntity<>(travelAgency, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(travelAgency, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete travelAgency", nickname = "TravelAgencyController.deleteTravelAgency")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "TravelAgency is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try {
            travelAgencyService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
