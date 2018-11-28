package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;

public interface RegistrationService {

    CustomerDto registration(RegistrationRequestDto registrationRequestDto);

}
