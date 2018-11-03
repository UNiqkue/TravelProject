package service;

import dao.UserDao;
import dao.entity.User;

import java.util.List;

public class UserService {

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
    public boolean registration(){ return true;}
    public boolean activate(){ return true;}
    public boolean login(){ return true;}
    public boolean buyTour(){ return true;}
    public boolean bookTour(){ return true;}
    public boolean cancelTour(){ return true;}
    public void watchTour(){}
}
