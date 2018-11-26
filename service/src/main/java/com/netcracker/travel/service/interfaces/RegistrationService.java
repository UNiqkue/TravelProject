package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;

import java.sql.SQLException;

public interface RegistrationService {

    CustomerDto registration(RegistrationRequestDto registrationRequestDto) throws SQLException;

}
