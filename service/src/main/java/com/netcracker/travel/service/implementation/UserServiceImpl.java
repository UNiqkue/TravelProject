package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.UserDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.User;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements AbstractService<User>, RegistrationService, AuthenticationService {

    private UserDaoImpl userDao;
    private TourDaoImpl tourDao;
    private UserConverter userConverter = new UserConverter();

    public UserServiceImpl(){
    }

    public List<User> getAll() {
        List<User> users = null;
        try {
            users = userDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto){
        UserDto userDto = new UserDto();
        userDto.setUsername(registrationRequestDto.getUsername());
        userDto.setEmail(registrationRequestDto.getEmail());
        userDto.setPassword(registrationRequestDto.getPassword());
        userDto.setActivationCode(registrationRequestDto.getAlias());
        userDto.setId(UUID.randomUUID());
        return registrationRequestDto;
    }

    public boolean activate(String str){
        return false;
    }

    public List<Tour> watchTours() {
        List<Tour> tours = null;
        try {
            tours = tourDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
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


}
