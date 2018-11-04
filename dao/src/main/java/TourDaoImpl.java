import entity.Tour;
import interfaces.AbstractDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TourDaoImpl implements AbstractDao<Tour> {

    private List<Tour> tours = new ArrayList<>();

    private static volatile TourDaoImpl instance;

    private TourDaoImpl(){}

    public static TourDaoImpl getInstance(){
        if (instance == null) {
            synchronized (TourDaoImpl.class) {
                if (instance == null) {
                    instance = new TourDaoImpl();
                }
            }
        }
        return instance;
    }

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
}
