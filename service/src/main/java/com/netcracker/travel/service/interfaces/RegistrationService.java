package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.*;

public interface RegistrationService {

    RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto);
    boolean activate(String str);

}
