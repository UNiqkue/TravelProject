package com.netcracker.travel.converter;

import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.entity.User;

public class UserConverter {

    public User convert(UserDto userDto){
        User user= new User();
        return user;
    }

    public UserDto convert(User user){
        UserDto userDto= new UserDto();
        return userDto;
    }
}
