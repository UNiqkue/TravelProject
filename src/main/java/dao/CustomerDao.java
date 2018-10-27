package dao;

import dao.entity.Customer;
import dao.repository.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer> {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Optional<Customer> get(Object object) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public int save(Customer customer) {
        return 0;
    }

    @Override
    public void update(Customer customer) {
    }

    @Override
    public void delete(Customer customer) {
    }
}
