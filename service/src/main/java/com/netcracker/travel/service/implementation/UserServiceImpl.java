package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.UserDaoImpl;
import com.netcracker.travel.dto.*;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import com.netcracker.travel.service.interfaces.RegistrationService;

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
        return userDao.getAll()
                .stream()
                .map(user -> userConverter.convert(user))
                .collect(Collectors.toList());
    }


    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto){
        UserDto userDto = new UserDto();
        userDto.setUsername(registrationRequestDto.getUsername());
        userDto.setEmail(registrationRequestDto.getEmail());
        userDto.setPassword(registrationRequestDto.getPassword());
        userDto.setActivationCode(registrationRequestDto.getActivationCode());
        userDto.setId(UUID.randomUUID());
        return registrationRequestDto;
    }

    public boolean activate(String str){
        return false;
    }

    public List<TourDto> watchTours() {
        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public UserDto updateUserInfo(UserDto userDto){
        return userConverter.convert(userDao.update(userConverter.convert(userDto)));
    }

    public UserDto checkUserInfo(UUID id){
        return userConverter.convert(userDao.getById(id));
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    public List<TourDto> getAllOrderedTours(UUID customerId){
        return tourDao.getToursById(customerId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

}
