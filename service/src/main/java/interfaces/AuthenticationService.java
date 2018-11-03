package interfaces;

import dto.LoginRequestDto;
import dto.LoginResponseDto;

public interface AuthenticationService{

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
