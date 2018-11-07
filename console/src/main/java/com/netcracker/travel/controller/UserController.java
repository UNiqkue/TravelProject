package com.netcracker.travel.controller;

import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.service.implementation.UserServiceImpl;

import java.util.List;
import java.util.UUID;

public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserDto getUserById(UUID id) {
        return null;
    }

    public UserDto getUserByName(String name) {
        return null;
    }

    public List<UserDto> getAllUsers() {
        return null;
    }

    public void save(UserDto userDto) { }

    public UserDto update() {
        return null;
    }

    public void delete(UUID id) {
    }

    public void watchTours(){}

    public void updateUserInfo(){}

    public void checkUserInfo(){}


}
