package com.netcracker.travel.controller;

import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;
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
@RequestMapping("/travelAgents")
public class TravelAgentController {

    private final TravelAgentServiceImpl travelAgentService;

    @Autowired
    public TravelAgentController(TravelAgentServiceImpl travelAgentService) {
        this.travelAgentService = travelAgentService;
    }

    @ApiOperation(value = "Gets all travelAgents", nickname = "TravelAgentController.getAllTravelAgents")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "TravelAgents")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TravelAgentDto>> getAllTravelAgents() {
        List<TravelAgentDto> travelAgents = travelAgentService.getAll();
        return new ResponseEntity<>(travelAgents, HttpStatus.OK);
    }

//    @ApiOperation(value = "Creates travelAgent", nickname = "TravelAgentController.addTravelAgent")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "TravelAgent is created")})
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> addTravelAgent(@RequestBody TravelAgentDto travelAgentDto) {
//        try {
//            String id = travelAgentService.add(travelAgentDto).getId();
//            return new ResponseEntity<>(id, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error in creation travelAgent", HttpStatus.BAD_REQUEST);
//        }
//    }

    @ApiOperation(value = "Update travelAgent", nickname = "TravelAgentController.updateTravelAgent")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "TravelAgent is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTravelAgent(@PathVariable("id") String id, @RequestBody TravelAgentDto travelAgentDto) {
        try {
            TravelAgentDto travelAgentDtoToChange = travelAgentService.getById(id);
            // todo rewrite to mapstruct
            BeanUtils.copyProperties(travelAgentDto, travelAgentDtoToChange, "id");
            travelAgentDto = travelAgentService.update(travelAgentDtoToChange);
            return new ResponseEntity<>(travelAgentDto.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation travelAgent", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Gets specific travelAgent", nickname = "TravelAgentController.getTravelAgent")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "TravelAgent")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TravelAgentDto> getTravelAgent(@PathVariable("id") String id) {
        TravelAgentDto travelAgent = travelAgentService.getById(id);
        if(travelAgent == null){
            return new ResponseEntity<>(travelAgent, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(travelAgent, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete travelAgent", nickname = "TravelAgentController.deleteTravelAgent")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "TravelAgent is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try {
            travelAgentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
