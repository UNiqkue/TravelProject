package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.service.BaseEntityService;
import com.netcracker.travel.service.SearchTourService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
@Service
public class CustomerServiceImpl implements UserDetailsService, BaseEntityService<CustomerDto>, SearchTourService {

    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final TourRepository tourRepository;

    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter;

    private final TourConverter tourConverter;

    @Autowired
    public CustomerServiceImpl(TourRepository tourRepository, CustomerRepository customerRepository, CustomerConverter customerConverter, TourConverter tourConverter) {
        this.tourRepository = tourRepository;
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
        this.tourConverter = tourConverter;
    }

    @Transactional
    public List<CustomerDto> getAll() {
        logger.info("CustomerServiceImpl findAll");
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(customerConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public CustomerDto getById(String id) {
        logger.info("CustomerServiceImpl getById user with id: {} ", id);
        return customerConverter.convert(customerRepository.findOne(id));
    }

    @Transactional
    public CustomerDto getByName(String username) {
        logger.info("CustomerServiceImpl getByName user with username: {}", username);
        return customerConverter.convert(customerRepository.findByUsername(username));
    }

    @Transactional
    public CustomerDto save(CustomerDto customerDto) {
        logger.info("CustomerServiceImpl save user: {}", customerDto.toString());
        customerDto.setId(UUID.randomUUID().toString());
        return customerConverter.convert(customerRepository.save(customerConverter.convert(customerDto)));
    }

    @Transactional
    public CustomerDto update(CustomerDto customerDto) {
        logger.info("CustomerServiceImpl update user: {}", customerDto.toString());
        return customerConverter.convert(customerRepository.save(customerConverter.convert(customerDto)));
    }

    @Transactional
    public void delete(String id) {
        logger.info("CustomerServiceImpl delete user with id: {} ", id);
        customerRepository.delete(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("CustomerServiceImpl loadUserByUsername customer with username: {}", username);
        return (UserDetails) customerRepository.findByUsername(username);
    }


    /**
     * viewOrderedTours
     **/

    @Transactional
    public List<TourDto> watchTours(UUID id) {
        return/* tourRepository.findAllByCustomerId(id)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());*/ null;
    }

    @Transactional
    public TourDto buyTour(UUID id, UUID customerId) {
        TourDto tourDto = tourConverter.convert(tourRepository.getById(id.toString()));
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

    @Transactional
    public TourDto cancelTour(UUID tourId, UUID userId) {
        TourDto tourDto = tourConverter.convert(tourRepository.getById(tourId.toString()));
        if (userId.equals(tourDto.getCustomer().getId())) {
            tourDto = tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    @Transactional
    public List<TourDto> searchTourByName(String name) {
        return tourRepository.findByName(name)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TourDto> searchTourByStartDate(Date startDate) {
        return tourRepository.findByStartDate(startDate)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TourDto> searchTourByEndDate(Date endDate) {
        return tourRepository.findByEndDate(endDate)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TourDto> searchTourByType(String type) {
        return tourRepository.findByType(type)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TourDto> searchTourByCountry(String country) {
        return tourRepository.findByCountry(country)
                .stream()
                .map(tourConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TourDto> searchTourByTravelAgency(String name) {
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
