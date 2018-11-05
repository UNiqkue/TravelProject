package com.netcracker.travel.converters;

import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.entity.User;

public class UserConverter {

    public User convert(UserDto userDto){
        User user= new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setActivationCode(userDto.getActivationCode());
        user.setRole(userDto.getRole());
        return user;
    }

    public UserDto convert(User user){
        UserDto userDto= new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setActivationCode(user.getActivationCode());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
