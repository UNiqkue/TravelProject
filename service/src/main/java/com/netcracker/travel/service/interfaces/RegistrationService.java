package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.*;

import java.sql.SQLException;

public interface RegistrationService {

    RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto) throws SQLException;
    boolean activate(String str);

}
