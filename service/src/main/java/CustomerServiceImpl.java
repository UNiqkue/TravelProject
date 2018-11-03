import dto.LoginRequestDto;
import dto.LoginResponseDto;
import entity.Customer;
import entity.Tour;
import interfaces.AbstractService;
import interfaces.AuthenticationService;

import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements AbstractService<Customer>, AuthenticationService {

    private CustomerDaoImpl customerDaoImpl;

    public Customer getById(UUID id) {
        return null;
    }

    public Customer getByName(String name) {
        return null;
    }

    public List<Customer> getAll() {
        return null;
    }

    public Customer save(Customer customer) {
        return null;
    }

    public void update(Customer customer) {
    }

    public void delete(UUID id) {
    }

    public void bookTour(){}

    public void buyTour(){

    }

    public void searchTour(){}

    public void cancelTour(){}

    public void viewOrderedTours(){}

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    public List<Tour> getTours(){return null;}
}
