package service;

import dao.UserDao;
import dao.entity.User;
import service.interfaces.LoginService;
import service.interfaces.MainService;
import service.interfaces.UserTourService;

import java.util.List;

public class UserService implements MainService<User>, LoginService, UserTourService {

    private UserDao userDao;
    private User user = new User();

    public void get(User user){}
    public List<User> getAll(){
        return null;
    }
    public User save(User user){
        return null;
    }
    public void delete(User user){}
    public void update(User user){}
    public boolean login(){ return true;}
    public boolean registration(){ return true;}
    public boolean activate(){ return true;}
    public boolean buyTour(){ return true;}
    public boolean bookTour(){ return true;}
    public boolean cancelTour(){ return true;}
    public void watchTour(){}
}
