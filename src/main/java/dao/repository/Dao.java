package dao.repository;

import java.util.List;
import java.util.Optional;

public interface Dao<T>{

    Optional<T> get(Object object);
    List<T> getAll();
    int save(T t);
    void update(T t);
    void delete(T t);
}
