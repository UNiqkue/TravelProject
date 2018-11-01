package service;

import dao.TravelAgentDao;
import dao.entity.Tour;
import dao.entity.TravelAgent;
import service.interfaces.DiscountService;
import service.interfaces.LoginService;
import service.interfaces.MainService;

import java.util.List;

public class TravelAgentService implements MainService<TravelAgent>, LoginService, DiscountService<Tour> {

    private TravelAgentDao travelAgentDao;
    private TravelAgent travelAgent = new TravelAgent();

    public TravelAgent save(TravelAgent travelAgent){
        return null;
    }
    public void delete(TravelAgent travelAgent){}
    public void get(TravelAgent travelAgent){}
    public void update(TravelAgent travelAgent){}
    public List<TravelAgent> getAll(){
        return null;
    }
    public boolean login(){ return true;}
    public void makeDiscount(Tour tour){}

}
