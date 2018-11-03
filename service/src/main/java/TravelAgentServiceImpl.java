import dto.LoginRequestDto;
import dto.LoginResponseDto;
import entity.Tour;
import entity.TravelAgency;
import entity.TravelAgent;
import interfaces.AbstractService;
import interfaces.AuthenticationService;

import java.util.List;
import java.util.UUID;

public class TravelAgentServiceImpl implements AbstractService<TravelAgent>, AuthenticationService {

    private TravelAgentDaoImpl travelAgentDaoImpl;

    public TravelAgent getById(UUID id) {
        return null;
    }

    public TravelAgent getByName(String name) {
        return null;
    }

    public List<TravelAgent> getAll() {
        return null;
    }

    public TravelAgent save(TravelAgent travelAgent) {
        return null;
    }

    public void update(TravelAgent travelAgent) {
    }

    public void delete(UUID id) {
    }

    public void checkExistenceTours(){}
    public void editTour(Tour tour){}
    public void viewOrderHystory(){}

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    public TravelAgency getTravelAgency(){return null;}
}
