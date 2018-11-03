package interfaces;

import java.util.List;
import java.util.UUID;

public interface AbstractDao<T>{

    T getById(UUID id);
    T getByName(String name);
    List<T> getAll();
    T save(T t);
    void update(T t);
    void delete(UUID id);
}
