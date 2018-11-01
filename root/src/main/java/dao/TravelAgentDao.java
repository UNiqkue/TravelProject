package dao;

import dao.entity.TravelAgent;
import dao.repository.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelAgentDao implements Dao<TravelAgent> {

    private List<TravelAgent> travelAgents = new ArrayList<>();
    @Override
    public Optional<TravelAgent> get(Object object) {
        return null;
    }

    @Override
    public List<TravelAgent> getAll() {
        return null;
    }

    @Override
    public int save(TravelAgent travelAgent) {
        return 0;
    }

    @Override
    public void update(TravelAgent travelAgent) {

    }

    @Override
    public void delete(TravelAgent travelAgent) {

    }
}
