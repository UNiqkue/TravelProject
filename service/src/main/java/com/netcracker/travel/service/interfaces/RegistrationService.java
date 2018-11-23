package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.*;

public interface RegistrationService {

    CustomerDto registration(RegistrationRequestDto registrationRequestDto);
    boolean activate(String str);

}
