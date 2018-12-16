package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.domain.enumeration.Role;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.TourDTO;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.service.BaseService;
import com.netcracker.travel.service.SearchTourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Transactional
@Service
public class CustomerServiceImpl implements BaseService<CustomerDTO>, SearchTourService {

    private final TourRepository tourRepository;

    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter;

    private final TourConverter tourConverter;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(TourRepository tourRepository, CustomerRepository customerRepository, CustomerConverter customerConverter, TourConverter tourConverter, PasswordEncoder passwordEncoder) {
        this.tourRepository = tourRepository;
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
        this.tourConverter = tourConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public List<CustomerDTO> getAll() {
        log.info("CustomerServiceImpl findAll");
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(customerConverter::convert)
                .collect(Collectors.toList());
    }

    public CustomerDTO getById(String id) {
        log.info("CustomerServiceImpl getById user with id: {} ", id);
        return customerConverter.convert(customerRepository.findOne(id));
    }

    public CustomerDTO getByName(String username) {
        log.info("CustomerServiceImpl getByName user with username: {}", username);
        return customerConverter.convert(customerRepository.findByUsername(username));
    }

    public CustomerDTO save(CustomerDTO customerDto) {
        log.info("CustomerServiceImpl save user: {}", customerDto.toString());
        customerDto.setId(UUID.randomUUID().toString());
        customerDto.setRole(Role.CUSTOMER);
        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        return customerConverter.convert(customerRepository.save(customerConverter.convert(customerDto)));
    }

    public CustomerDTO update(String id, CustomerDTO customerDto) {
        log.info("CustomerServiceImpl update user: {}", customerDto.toString());
        customerDto.setId(id);
        return customerConverter.convert(customerRepository.save(customerConverter.convert(customerDto)));
    }

    public void delete(String id) {
        log.info("CustomerServiceImpl delete user with id: {} ", id);
        customerRepository.delete(id);
    }


    public List<TourDTO> watchTours(UUID id) {
        return/* tourRepository.findAllByCustomerId(id)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());*/ null;
    }

    public TourDTO buyTour(UUID id, UUID customerId) {
        TourDTO tourDto = tourConverter.convert(tourRepository.getById(id.toString()));
        if (customerId.equals(tourDto.getCustomer().getId()) || tourDto.isFree()) {
            tourDto.setCustomer(customerRepository.findById(customerId.toString()));
            tourDto.setFree(false);
            tourDto = tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
            System.out.println("You bought tour");
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    public TourDTO cancelTour(UUID tourId, UUID userId) {
        TourDTO tourDto = tourConverter.convert(tourRepository.getById(tourId.toString()));
        if (userId.equals(tourDto.getCustomer().getId())) {
            tourDto = tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    public List<TourDTO> searchTourByName(String name) {
        return tourRepository.findByName(name)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByStartDate(Date startDate) {
        return tourRepository.findByStartDate(startDate)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByEndDate(Date endDate) {
        return tourRepository.findByEndDate(endDate)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByType(String type) {
        return tourRepository.findByType(type)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByCountry(String country) {
        return tourRepository.findByCountry(country)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByTravelAgency(String name) {
        return/* tourRepository.findByTravelAgencyId(travelAgencyRepository.findByName(name).get(0).getId())
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());*/ null;
    }

    public void verifyPhoneNumber(String phoneNumber) throws PhoneNumberException {
        String regPhoneNumber = "((80|\\+375)[\\s|-]?(29|25|33|44))[\\s|-]?(\\d{7}|\\d{3}[\\s|-]?\\d{2}[\\s|-]?\\d{2})";
        Pattern pattern = Pattern.compile(regPhoneNumber);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean bl = matcher.matches();
        System.out.println(bl);
        if (!bl) {
            throw new PhoneNumberException("Invalid phone number");
        }
    }


}
