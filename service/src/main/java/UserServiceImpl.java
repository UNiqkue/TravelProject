import dto.LoginRequestDto;
import dto.LoginResponseDto;
import dto.RegistrationRequestDto;
import entity.User;
import interfaces.AbstractService;
import interfaces.AuthenticationService;
import interfaces.RegistrationService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements AbstractService<User>, RegistrationService, AuthenticationService {

    private UserDaoImpl userDaoImpl;

    public User getById(UUID id) {
        return null;
    }

    public User getByName(String name) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }

    public User save(User user) {
        return null;
    }

    public void update(User user) {
    }

    public void delete(UUID id) {
    }

    public RegistrationRequestDto registration(RegistrationRequestDto registrationRequestDto){ return null;}

    public boolean activate(String str){
        return false;
    }

    public void watchTours(){}

    public void updateUserInfo(){}

    public void checkUserInfo(){}

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }


}
