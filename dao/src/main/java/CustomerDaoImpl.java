import entity.Customer;
import interfaces.AbstractDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerDaoImpl implements AbstractDao<Customer> {

    private List<Customer> customers = new ArrayList<>();

    private static CustomerDaoImpl instance;

    private CustomerDaoImpl(){}

    public static CustomerDaoImpl getInstance(){
        if(instance==null){
            instance = new CustomerDaoImpl();
        }
        return instance;
    }

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
}
