package com.netcracker.travel.controller;

import com.netcracker.travel.dto.TourDTO;
import com.netcracker.travel.service.implementation.TourServiceImpl;
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
    public ResponseEntity<List<TourDTO>> getAllTours() {
        log.info("TourController getAllTours");
        List<TourDTO> tours = tourService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates tour", nickname = "TourController.addTour")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tour is created")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTour(@RequestBody TourDTO tourDto) {
        log.info("TourController addTour: {}", tourDto.toString());
        try {
            String id = tourService.save(tourDto).getId();
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation tour", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update tour", nickname = "TourController.updateTour")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tour is updated")})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTour(@PathVariable("id") String id, @RequestBody TourDTO tourDto) {
        log.info("TourController update tour: {}", tourDto.toString());
        try {
            tourDto = tourService.update(id, tourDto);
            return new ResponseEntity<>(tourDto.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation tour", HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TourDTO> getTour(@PathVariable("id") String id) {
        log.info("TourController getTour by id: {} ", id);
        TourDTO tour = tourService.getById(id);
        if(tour == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete tour", nickname = "TourController.deleteTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteTour(@PathVariable("id") String id) {
        log.info("TourController delete tour by id: {} ", id);
        try {
            tourService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @ApiOperation(value = "Gets all tours of customer", nickname = "CustomerController.getAllCustomerTours")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Customers")})
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<TourDTO>> getAllCustomerTours(@RequestBody CustomerDTO customerDto) {
//        log.info("CustomerController getAllCustomerTours");
//        List<TourDTO> tours = tourService.watchCustomerTours(customerDto);
//        return new ResponseEntity<>(tours, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Buy Tour", nickname = "CustomerController.buyTour")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour is bought")})
//    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TourDTO> buyTour(@PathVariable("id") String tourId, @RequestBody CustomerDTO customerDto) {
//        log.info("CustomerController buyTour");
//        TourDTO tour = tourService.buyTour(tourId, customerDto);
//        return new ResponseEntity<>(tour, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Cancel Tour", nickname = "CustomerController.cancelTour")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour is canceled")})
//    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TourDTO> cancelTour(@PathVariable("id") String tourId, @RequestBody CustomerDTO customerDto) {
//        log.info("CustomerController cancelTour");
//        TourDTO tour = tourService.cancelTour(tourId, customerDto.getId());
//        return new ResponseEntity<>(tour, HttpStatus.OK);
//    }

}
/*
fetch('/tours',{ method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ name: 'Something', type: 'CRUISE'})}).then(result => result.json().then(console.log))

 fetch('/tours/1').then(response => response.json().then(console.log))

 fetch('/tours/4', { method: 'DELETE' }).then(result => console.log(result))

 fetch('/tours/4028e4c1679f78ad01679f8165650000',{ method: 'PUT', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ name: 'Tour on Italy', description: '3 person', price: 200, type: 'EXCURSION', country: 'italy', startDate: '2019-06-06', endDate: '2019-06-29', id: '4028e4c1679f78ad01679f8165650000'})}).then(result => result.json().then(console.log))

 */