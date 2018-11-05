package com.netcracker.travel.services.interfaces;

import com.netcracker.travel.dto.RegistrationRequestDto;

public interface RegistrationService {

    RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto);
    boolean activate(String str);

}
