package service;

import dao.TravelAgencyDao;
import dao.entity.TravelAgency;
import service.interfaces.MainService;

import java.util.List;

public class TravelAgencyService implements MainService<TravelAgency> {

    private TravelAgencyDao travelAgencyDao;
    private TravelAgency travelAgency = new TravelAgency();

    public void get(TravelAgency travelAgency){}
    public List<TravelAgency> getAll(){
        return null;
    }
    public TravelAgency save(TravelAgency travelAgency){
        return null;
    }
    public void delete(TravelAgency travelAgency){}
    public void update(TravelAgency travelAgency){}


}
