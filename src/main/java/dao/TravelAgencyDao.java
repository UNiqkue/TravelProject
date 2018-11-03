package dao;

import dao.entity.TravelAgency;
import dao.repository.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelAgencyDao implements Dao<TravelAgency> {

    private List<TravelAgency> travelAgencies = new ArrayList<>();

    @Override
    public Optional<TravelAgency> get(Object object) {
        return null;
    }

    @Override
    public List<TravelAgency> getAll() {
        return null;
    }

    @Override
    public int save(TravelAgency travelAgency) {
        return 0;
    }

    @Override
    public void update(TravelAgency travelAgency) {

    }

    @Override
    public void delete(TravelAgency travelAgency) {

    }
}
