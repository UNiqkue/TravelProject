package com.netcracker.travel.controller;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.service.implementation.TourServiceImpl;
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
@RequestMapping("/tours")
public class TourController {

    private final TourServiceImpl tourService;

    @Autowired
    public TourController(TourServiceImpl tourService) {
        this.tourService = tourService;
    }

    @ApiOperation(value = "Gets all tours", nickname = "TourController.getAllTours")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tours")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDto>> getAllTours() {
        List<TourDto> tours = tourService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates tour", nickname = "TourController.addTour")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tour is created")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTour(@RequestBody TourDto tourDto) {
        try {
            String id = tourService.add(tourDto).getId();
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation tour", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update tour", nickname = "TourController.updateTour")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tour is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTour(@PathVariable("id") String id, @RequestBody TourDto tourDto) {
        try {
            TourDto tourDtoToChange = tourService.get(id);
            BeanUtils.copyProperties(tourDto, tourDtoToChange, "id");
            tourDto = tourService.update(tourDtoToChange);
            return new ResponseEntity<>(tourDto.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation tour", HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TourDto> getTour(@PathVariable("id") String id) {
        TourDto tour = tourService.get(id);
        if(tour == null){
            return new ResponseEntity<>(tour, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete tour", nickname = "TourController.deleteTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteTour(@PathVariable("id") String id) {
        try {
            tourService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
/*
fetch('/tours',{ method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ name: 'Something', type: 'CRUISE'})}).then(result => result.json().then(console.log))

 fetch('/tours/1').then(response => response.json().then(console.log))

 fetch('/tours/4', { method: 'DELETE' }).then(result => console.log(result))

 fetch('/tours/4028e4c1679f78ad01679f8165650000',{ method: 'PUT', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ name: 'Tour on Italy', description: '3 person', price: 200, type: 'EXCURSION', country: 'italy', startDate: '2019-06-06', endDate: '2019-06-29', id: '4028e4c1679f78ad01679f8165650000'})}).then(result => result.json().then(console.log))

 */