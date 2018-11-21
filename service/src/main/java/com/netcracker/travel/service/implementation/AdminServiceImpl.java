package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.AdminDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.User;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.exception.EmailExistException;
import com.netcracker.travel.exception.UsernameExistException;
import com.netcracker.travel.service.interfaces.AbstractService;
import com.netcracker.travel.service.interfaces.RegistrationService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AbstractService<AdminDto>, RegistrationService {

    private AdminDaoImpl adminDao = AdminDaoImpl.getInstance();
    private TourDaoImpl tourDao = TourDaoImpl.getInstance();

    private AdminConverter adminConverter = new AdminConverter();
    private TourConverter tourConverter = new TourConverter();

    public AdminServiceImpl(){
    }

    public User getByUsername(String username) {
        return adminDao.getByUsername(username);
    }

    public List<AdminDto> getAll() {
        return adminDao.getAll()
                .stream()
                .map(user -> adminConverter.convert(user))
                .collect(Collectors.toList());
    }

    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto){
        checkExisting(registrationRequestDto);
       AdminDto adminDto= new AdminDto();
        adminDto.setId(UUID.randomUUID());
        adminDto.setFirstName(registrationRequestDto.getFirstName());
        adminDto.setLastName(registrationRequestDto.getLastName());
        adminDto.setUsername(registrationRequestDto.getUsername());
        adminDto.setEmail(registrationRequestDto.getEmail());
        adminDto.setPassword(registrationRequestDto.getPassword());
        adminDto.setActivationCode(UUID.randomUUID().toString());
        adminDto.setRole(Role.GUEST);
        adminDao.save(adminConverter.convert(adminDto));
        return registrationRequestDto;
    }

    private void checkExisting(RegistrationRequestDto registrationRequestDto) {
        checkUsernameExist(registrationRequestDto.getUsername());
        checkEmailExist(registrationRequestDto.getEmail());
    }

    private void checkUsernameExist(String username) {
       AdminDto adminDto= adminConverter.convert(adminDao.getByUsername(username));
        if (adminDto!= null) {
            throw new UsernameExistException();
        }
    }

    private void checkEmailExist(String email) {
       AdminDto adminDto= adminConverter.convert(adminDao.getByEmail(email));
        if (adminDto!= null) {
            throw new EmailExistException();
        }
    }

    public boolean activate(String str){
       AdminDto adminDto= adminConverter.convert(adminDao.getByActivationCode(str));

        if(adminDto== null){
            return false;
        }

        adminDto.setRole(Role.GUEST);
        adminDto.setActivationCode(null);

        return true;
    }

    public List<TourDto> watchTours() {
        return tourDao.getAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

    public AdminDto updateInfo(UUID id){
        return adminConverter.convert(adminDao.update(adminDao.getById(id)));
    }

    public AdminDto checkInfo(UUID id){
        return adminConverter.convert(adminDao.getById(id));
    }


    public List<TourDto> getAllOrderedTours(UUID customerId){
        return tourDao.getToursById(customerId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
    }

}
