package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.UserDaoImpl;
import com.netcracker.travel.dto.*;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserServiceImpl implements AbstractService<UserDto>, RegistrationService, AuthenticationService {


    private UserDaoImpl userDao = UserDaoImpl.getInstance();
    private TourDaoImpl tourDao = TourDaoImpl.getInstance();
    private UserConverter userConverter = new UserConverter();
    private TourConverter tourConverter = new TourConverter();

    public UserServiceImpl(){
    }

    public List<UserDto> getAll() {
        List<UserDto> users = null;
        try {
            users = userDao.getAll()
                    .stream()
                    .map(user -> userConverter.convert(user))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto){
        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setUsername(registrationRequestDto.getUsername());
        userDto.setEmail(registrationRequestDto.getEmail());
        userDto.setPassword(registrationRequestDto.getPassword());
        userDto.setActivationCode(registrationRequestDto.getActivationCode());
        return registrationRequestDto;
    }

    public boolean activate(String str){
        return false;
    }

    public List<TourDto> watchTours() {
        List<TourDto> tours = null;
        try {
            tours = tourDao.getAll()
                    .stream()
                    .map(tour -> tourConverter.convert(tour))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    public UserDto updateUserInfo(UserDto userDto){
        UserDto temp = null;
        try {
            temp = userConverter.convert(userDao.update(userConverter.convert(userDto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public UserDto checkUserInfo(UUID id){
        UserDto temp = null;
        try {
            temp = userConverter.convert(userDao.getById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }


    public List<TourDto> getAllOrderedTours(UUID customerId){
        List<TourDto> tours = null;
        try {
            tours = tourDao.getToursById(customerId)
                    .stream()
                    .map(tour -> tourConverter.convert(tour))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

}
