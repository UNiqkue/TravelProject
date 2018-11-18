package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.UserConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.UserDaoImpl;
import com.netcracker.travel.dto.LoginRequestDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.UserDto;
import com.netcracker.travel.entity.User;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.UsernameExistException;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.AuthenticationService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.sql.SQLException;
import java.util.Collections;
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

    public List<UserDto> getAll() throws SQLException {
        return userDao.getAll()
                .stream()
                .map(user -> userConverter.convert(user))
                .collect(Collectors.toList());
    }


    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto) throws SQLException {
        checkExisting(registrationRequestDto);
        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setFirstName(registrationRequestDto.getFirstName());
        userDto.setLastName(registrationRequestDto.getLastName());
        userDto.setUsername(registrationRequestDto.getUsername());
        userDto.setEmail(registrationRequestDto.getEmail());
        userDto.setPassword(registrationRequestDto.getPassword());
        userDto.setActivationCode(UUID.randomUUID().toString());
        userDto.setRole(Collections.singleton(Role.ANONYMUSER));
        userDao.save(userConverter.convert(userDto));
        return registrationRequestDto;
    }

    private void checkExisting(RegistrationRequestDto registrationRequestDto) {
        checkUsernameExist(registrationRequestDto.getUsername());
        checkEmailExist(registrationRequestDto.getEmail());
    }

    private void checkUsernameExist(String username) {
        UserDto userDto = userConverter.convert(userDao.getByUsername(username));
        if (userDto != null) {
            throw new UsernameExistException();
        }
    }

    private void checkEmailExist(String email) {
        User user = userDao.getByEmail(email);
        if (user != null) {
            throw new EmailExistException();
        }
    }

    public boolean activate(String str) {
        UserDto userDto = userConverter.convert(userDao.getByActivationCode(str));

        if(userDto == null){
            return false;
        }

        userDto.setRole(Collections.singleton(Role.ANONYMUSER));
        userDto.setActivationCode(null);

        return true;
    }

    public List<TourDto> watchTours() {
        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public UserDto updateUserInfo(UserDto userDto) throws SQLException {
        return userConverter.convert(userDao.update(userConverter.convert(userDto)));
    }

    public UserDto checkUserInfo(UUID id) throws SQLException{
        return userConverter.convert(userDao.getById(id));
    }

    public boolean login(LoginRequestDto loginRequestDto) {
        UserDto userDto = userConverter.convert(userDao.getByUsername(loginRequestDto.getUsername()));
        if(userDto.getPassword().equals(loginRequestDto.getPassword())) {
            return true;
        }
        return false;
    }

    public List<TourDto> getAllOrderedTours(UUID customerId) throws SQLException{
        return tourDao.getToursById(customerId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

}
