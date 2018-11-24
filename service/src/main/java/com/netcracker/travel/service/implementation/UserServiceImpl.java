package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.UserDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements AbstractService<UserDto>, RegistrationService, AuthenticationService {

    private UserDaoImpl userDao = UserDaoImpl.getInstance();
    private TourDaoImpl tourDao = TourDaoImpl.getInstance();

    private UserConverter userConverter = new UserConverter();
    private TourConverter tourConverter = new TourConverter();

    public UserServiceImpl(){
    }

    public List<UserDto> getAll() {
        return new ArrayList<>();
    }

    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto){
        return registrationRequestDto;
    }

    private void checkExisting(RegistrationRequestDto registrationRequestDto) {
    }

    private void checkUsernameExist(String username) {
    }

    private void checkEmailExist(String email) {
    }

    public boolean activate(String str){
        return true;
    }

    public List<TourDto> watchTours() {
        return new ArrayList<>();
    }

    public UserDto updateUserInfo(UserDto userDto){
        return userDto;
    }

    public UserDto checkUserInfo(UUID id){
        return null;
    }

    public boolean login(LoginRequestDto loginRequestDto) {
        return false;
    }

    public List<TourDto> getAllOrderedTours(UUID customerId){
        return new ArrayList<>();
    }

}
