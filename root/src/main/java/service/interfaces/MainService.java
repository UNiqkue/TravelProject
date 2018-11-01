package service.interfaces;

import java.util.List;

public interface MainService<T> {

    void get(T t);
    List<T> getAll();
    T save(T t);
    void update(T t);
    void delete(T t);

}
