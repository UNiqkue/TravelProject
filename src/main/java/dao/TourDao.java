package dao;

import dao.entity.Tour;
import dao.repository.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TourDao implements Dao<Tour> {

    private List<Tour> tours = new ArrayList<>();

    @Override
    public Optional<Tour> get(Object object) {
        return null;
    }

    @Override
    public List<Tour> getAll() {
        return null;
    }

    @Override
    public int save(Tour tour) {
        return 0;
    }

    @Override
    public void update(Tour tour) {
    }

    @Override
    public void delete(Tour tour) {
    }
}
