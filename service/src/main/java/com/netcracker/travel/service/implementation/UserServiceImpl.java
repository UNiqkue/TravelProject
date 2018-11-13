package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.LoginResponseDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements AbstractService<UserDto>, RegistrationService, AuthenticationService {

    private UserConverter userConverter = new UserConverter();

    public UserServiceImpl(){
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

    public void save(UserDto userDto) {
    //    userDaoImpl.save(userConverter.convert(userDto));
    }

    public void update(UserDto userDto) {
    }

    public void delete(UUID id) {
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

    public void watchTours(){}

    public void updateUserInfo(){}

    public void checkUserInfo(){}

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }


}
