package interfaces;

import dto.RegistrationRequestDto;

public interface RegistrationService {

    RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto);
    boolean activate(String str);

}
