package dao;

import dao.entity.User;
import dao.repository.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private List<User> users = new ArrayList<>();

    @Override
    public Optional<User> get(Object object) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(User user) {
    }
}
