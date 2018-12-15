package com.netcracker.travel.service;

import com.netcracker.travel.dto.CustomerDTO;
import com.netcracker.travel.dto.RegistrationRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    CustomerDTO registration(RegistrationRequestDTO registrationRequestDto);

}
