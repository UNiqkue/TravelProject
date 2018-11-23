package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements AbstractService<CustomerDto>, RegistrationService {

    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();

    private CustomerConverter customerConverter = new CustomerConverter();
    private TourConverter tourConverter = new TourConverter();

    public CustomerServiceImpl(){
    }

    public CustomerDto getByUsername(String username) {
        return customerConverter.convert(customerDao.getByUsername(username));
    }

    public List<CustomerDto> getAll(){
        return customerDao.getAll()
                .stream()
                .map(customer -> customerConverter.convert(customer))
                .collect(Collectors.toList());
    }

    public TourDto bookTour(UUID id, UUID customerId) {
        TourDto temp = buyTour(id, customerId);
        System.out.println("You have 3 days to pay for the tour");
        return temp;
    }

    public TourDto buyTour(UUID id, UUID customerId) {
        TourDto tourDto = tourConverter.convert(tourDao.getById(id));
        tourDto.setCustomerId(customerId);
        tourDto.setFree(false);
        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public List<TourDto> searchTourByName(String name){
        return tourDao.getByName(name)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }
    public List<TourDto> searchTourByDate(Date startDate, Date endDate){
        return tourDao.getByDate(startDate, endDate)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByType(String type){
        return tourDao.getByType(type)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> searchTourByCountry(String country){
        return tourDao.getByCountry(country)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public TourDto cancelTour(UUID tourId){
        TourDto tourDto = tourConverter.convert(tourDao.getById(tourId));
        tourDto.setCustomerId(null);
        tourDto.setFree(true);
        return tourConverter.convert(tourDao.update(tourConverter.convert(tourDto)));
    }

    public List<TourDto> viewOrderedTours(UUID id){
        return tourDao.getToursById(id)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> getAllOrderedTours(UUID customerId){
        return tourDao.getToursById(customerId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public CustomerDto updatePhoneNumber(String username, String phoneNumber) {
        CustomerDto customerDto = getByUsername(username);
        customerDto.setPhoneNumber(phoneNumber);
        return customerConverter.convert(customerDao.update(customerConverter.convert(customerDto)));
    }

    public CustomerDto registration(RegistrationRequestDto registrationRequestDto){
     //   checkExisting(registrationRequestDto);
        CustomerDto customerDto= new CustomerDto();
        customerDto.setId(UUID.randomUUID());
        customerDto.setFirstName(registrationRequestDto.getFirstName());
        customerDto.setLastName(registrationRequestDto.getLastName());
        customerDto.setUsername(registrationRequestDto.getUsername());
        customerDto.setEmail(registrationRequestDto.getEmail());
        customerDto.setPassword(registrationRequestDto.getPassword());
        customerDto.setActivationCode(registrationRequestDto.getActivationCode());
        customerDto.setRole(Role.GUEST);
        customerDto.setPassportInfo(registrationRequestDto.getPassportInfo());
        customerDto.setCardNumber(registrationRequestDto.getCardNumber());
        customerDto.setDateOfBirth(registrationRequestDto.getDateOfBirth());
        customerDto.setPhoneNumber(registrationRequestDto.getPhoneNumber());
        return customerConverter.convert(customerDao.save(customerConverter.convert(customerDto)));
    }

   /* private void checkExisting(RegistrationRequestDto registrationRequestDto) {
        checkUsernameExist(registrationRequestDto.getUsername());
        checkEmailExist(registrationRequestDto.getEmail());
    }

    private void checkUsernameExist(String username) {
        CustomerDto customerDto = customerConverter.convert(customerDao.getByUsername(username));
        if (customerDto!= null) {
            throw new UsernameExistException();
        }
    }

    private void checkEmailExist(String email) {
        CustomerDto customerDto = customerConverter.convert(customerDao.getByEmail(email));
        if (customerDto!= null) {
            throw new EmailExistException();
        }
    }*/

    public boolean activate(String str){
        CustomerDto customerDto = customerConverter.convert(customerDao.getByActivationCode(str));

        if(customerDto== null){
            return false;
        }

        customerDto.setRole(Role.CUSTOMER);
        customerDto.setActivationCode(null);

        return true;
    }


}
