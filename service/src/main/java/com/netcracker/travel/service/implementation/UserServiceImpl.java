package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dao.implementation.UserDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.entity.User;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements AbstractService<UserDto>, RegistrationService, AuthenticationService {

    private UserDaoImpl userDaoImpl;
    private UserConverter userConverter = new UserConverter();

    public UserServiceImpl(){
        userDaoImpl = UserDaoImpl.getInstance();
    }

    public UserDto getById(UUID id) {
        return null;
    }

    public UserDto getByName(String name) {
        return null;
    }

    public List<UserDto> getAll() {

     //   return userDaoImpl.getAll().stream().map(user -> userConverter.convert(user)).collect(Collectors.toList());
        return null;
    }

    public UserDto save(UserDto userDto) {
        User user = userConverter.convert(userDto);
        userDaoImpl.save(user);

        return null;
    }

    public void update(UserDto userDto) {
    }

    public void delete(UUID id) {
    }

    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto){ return null;}

    public boolean activate(String str){
        return false;
    }

    public void watchTours(){}

    public void updateUserInfo(){}

    public void checkUserInfo(){}

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }


}
