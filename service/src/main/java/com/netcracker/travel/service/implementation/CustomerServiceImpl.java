package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerMapper;
import com.netcracker.travel.converter.TourMapper;
import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.TourDTO;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.PhoneNumberException;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.service.BaseService;
import com.netcracker.travel.service.SearchTourService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
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

    private TourMapper tourMapper = Mappers.getMapper(TourMapper.class);

    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(TourRepository tourRepository, CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.tourRepository = tourRepository;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<CustomerDTO> getAll() {
        log.info("CustomerServiceImpl findAll");
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getById(String id) {
        log.info("CustomerServiceImpl getById user with id: {} ", id);
        return customerMapper.customerToCustomerDTO(customerRepository.findOne(id));
    }

    public CustomerDTO getByName(String username) {
        log.info("CustomerServiceImpl getByName user with username: {}", username);
        return customerMapper.customerToCustomerDTO(customerRepository.findByUsername(username));
    }

    public CustomerDTO save(CustomerDTO customerDto) {
        log.info("CustomerServiceImpl save user: {}", customerDto.toString());
        customerDto.setId(UUID.randomUUID().toString());
        customerDto.setRole(Role.CUSTOMER);
        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        return customerMapper.customerToCustomerDTO(customerRepository.save(customerMapper.customerDTOtoCustomer(customerDto)));
    }

    public CustomerDTO update(String id, CustomerDTO customerDto) {
        log.info("CustomerServiceImpl update user: {}", customerDto.toString());
        customerDto.setId(id);
        return customerMapper.customerToCustomerDTO(customerRepository.save(customerMapper.customerDTOtoCustomer(customerDto)));
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
        TourDTO tourDto = tourMapper.tourToTourDTO(tourRepository.getById(id.toString()));
        if (customerId.equals(tourDto.getCustomer().getId()) || tourDto.isFree()) {
            tourDto.setCustomer(customerRepository.findById(customerId.toString()));
            tourDto.setFree(false);
            tourDto = tourMapper.tourToTourDTO(tourRepository.save(tourMapper.tourDTOtoTour(tourDto)));
            System.out.println("You bought tour");
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    public TourDTO cancelTour(UUID tourId, UUID userId) {
        TourDTO tourDto = tourMapper.tourToTourDTO(tourRepository.getById(tourId.toString()));
        if (userId.equals(tourDto.getCustomer().getId())) {
            tourDto = tourMapper.tourToTourDTO(tourRepository.save(tourMapper.tourDTOtoTour(tourDto)));
        } else {
            System.out.println("You can't do it!!!");
        }
        return tourDto;
    }

    public List<TourDTO> searchTourByName(String name) {
        return tourRepository.findByName(name)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByStartDate(Date startDate) {
        return tourRepository.findByStartDate(startDate)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByEndDate(Date endDate) {
        return tourRepository.findByEndDate(endDate)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByType(String type) {
        return tourRepository.findByType(type)
                .stream()
                .map(tourMapper::tourToTourDTO)
                .collect(Collectors.toList());
    }

    public List<TourDTO> searchTourByCountry(String country) {
        return tourRepository.findByCountry(country)
                .stream()
                .map(tourMapper::tourToTourDTO)
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
