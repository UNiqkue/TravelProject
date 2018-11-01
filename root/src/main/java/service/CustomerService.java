package service;

import dao.CustomerDao;
import dao.entity.Customer;
import service.interfaces.LoginService;
import service.interfaces.MainService;

import java.util.List;

public class CustomerService implements MainService<Customer>, LoginService {

    private CustomerDao customerDao;
    private Customer customer = new Customer();

    public void get(Customer customer){}
    public List<Customer> getAll(){
        return null;
    }
    public Customer save(Customer customer){
        return null;
    }
    public void update(Customer customer){}
    public void delete(Customer customer){}
    public boolean login(){ return true;}
}
