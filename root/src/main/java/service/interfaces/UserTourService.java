package service.interfaces;

public interface UserTourService {

    boolean registration();
    boolean activate();
    boolean buyTour();
    boolean bookTour();
    boolean cancelTour();
    void watchTour();
}
