package service;

import dao.TourDao;
import dao.entity.Tour;
import service.interfaces.MainService;

import java.util.List;

public class TourService implements MainService<Tour> {

    private TourDao tourDao;
    private Tour tour = new Tour();

    public void get(Tour tour){}
    public List<Tour> getAll(){
        return null;
    }
    public Tour save(Tour tour){
        return null;
    }
    public void update(Tour tour){}
    public void delete(Tour tour){}

}
