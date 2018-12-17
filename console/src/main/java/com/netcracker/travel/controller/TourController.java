package com.netcracker.travel.controller;

import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.TourDTO;
import com.netcracker.travel.entity.enumeration.TypeTour;
import com.netcracker.travel.service.implementation.TourServiceImpl;
import com.netcracker.travel.util.UserParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getAllTours() {
        log.info("TourController getAllTours");
        List<TourDTO> tours = tourService.getAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/all/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TourDTO> getTour(@PathVariable("id") String id) {
        log.info("TourController getTour by id: {} ", id);
        TourDTO tour = tourService.getById(id);
        if(tour == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates tour", nickname = "TourController.addTour")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tour is created")})
    @PostMapping
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
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateTour(@PathVariable("id") String id, @RequestBody TourDTO tourDto) {
        log.info("TourController update tour: {}", tourDto.toString());
        try {
            tourDto = tourService.update(id, tourDto);
            return new ResponseEntity<>(tourDto.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in creation tour", HttpStatus.BAD_REQUEST);
        }
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

    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getToursByName")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/catalog/tour_name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getToursByName(@PathVariable("name") String name) {
        log.info("TourController getTours by name: {} ", name);
        List<TourDTO> tours = tourService.searchTourByName(name);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getToursByCountry")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/catalog/country_name/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getToursByCountry(@PathVariable("country") String country) {
        log.info("TourController getTours by country: {} ", country);
        List<TourDTO> tours = tourService.searchTourByCountry(country);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getToursByStartDate")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/catalog/start_date/{startDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getToursByStartDate(@PathVariable("startDate") Date startDate) {
        log.info("TourController getTours by startDate: {} ", startDate);
        List<TourDTO> tours = tourService.searchTourByStartDate(startDate);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getToursByEndDate")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/catalog/end_date/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getToursByEndDate(@PathVariable("endDate") Date endDate) {
        log.info("TourController getTours by endDate: {} ", endDate);
        List<TourDTO> tours = tourService.searchTourByEndDate(endDate);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getToursByType")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/catalog/type_tour/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getToursByType(@PathVariable("type") TypeTour type) {
        log.info("TourController getTours by type: {} ", type);
        List<TourDTO> tours = tourService.searchTourByType(type);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets specific tour", nickname = "TourController.getToursByTravelAgencyName")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour")})
    @GetMapping(value = "/catalog/agency_name/{travelAgencyName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getToursByTravelAgencyName(@PathVariable("travelAgencyName") String travelAgencyName) {
        log.info("TourController getTours by travelAgencyName: {} ", travelAgencyName);
        List<TourDTO> tours = tourService.searchTourByTravelAgency(travelAgencyName);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets all tours of customer", nickname = "CustomerController.getAllCustomerTours")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Customers")})
    @GetMapping(value = "/customer/tours",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TourDTO>> getAllCustomerTours(@RequestBody CustomerDTO customerDto) {
        log.info("CustomerController getAllCustomerTours");
        List<TourDTO> tours = tourService.watchCustomerTours(customerDto);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @ApiOperation(value = "Buy Tour", nickname = "CustomerController.buyTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour is bought")})
    @PutMapping(value = "/booking/{id}/buy",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TourDTO> buyTour(@PathVariable("id") String tourId) {
        log.info("CustomerController buyTour");
        String userId = ((UserParams) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        TourDTO tour = tourService.buyTour(tourId, userId);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @ApiOperation(value = "Cancel Tour", nickname = "CustomerController.cancelTour")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Tour is canceled")})
    @PutMapping(value = "/booking/{id}/cancel",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TourDTO> cancelTour(@PathVariable("id") String tourId, @RequestBody CustomerDTO customerDto) {
        log.info("CustomerController cancelTour");
        TourDTO tour = tourService.cancelTour(tourId, customerDto.getId());
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

}
/*
fetch('/tours',{ method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ name: 'Something', type: 'CRUISE'})}).then(result => result.json().then(console.log))

 fetch('/tours/1').then(response => response.json().then(console.log))

 fetch('/tours/4', { method: 'DELETE' }).then(result => console.log(result))

 fetch('/tours/4028e4c1679f78ad01679f8165650000',{ method: 'PUT', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ name: 'Tour on Italy', description: '3 person', price: 200, type: 'EXCURSION', country: 'italy', startDate: '2019-06-06', endDate: '2019-06-29', id: '4028e4c1679f78ad01679f8165650000'})}).then(result => result.json().then(console.log))

 */