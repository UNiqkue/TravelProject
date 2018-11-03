import entity.Customer;
import entity.Tour;
import interfaces.AbstractService;

import java.util.List;
import java.util.UUID;

public class TourServiceImpl implements AbstractService<Tour> {

    private TourDaoImpl tourDaoImpl;

    public Tour getById(UUID id) {
        return null;
    }

    public Tour getByName(String name) {
        return null;
    }

    public List<Tour> getAll() {
        return null;
    }

    public Tour save(Tour tour) {
        return null;
    }

    public void update(Tour tour) {
    }

    public void delete(UUID id) {
    }

    public Customer getCustomer(){return null;}

}
