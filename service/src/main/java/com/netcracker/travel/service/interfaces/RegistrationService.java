package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    CustomerDto registration(RegistrationRequestDto registrationRequestDto);

}
