package com.netcracker.travel.service.interfaces;

import java.util.Collection;
import java.util.UUID;

public interface AbstractService<T> {

    T getById(UUID id);
    T getByName(String name);
    Collection<T> getAll();
    void save(T t);
    void update(T t);
    void delete(UUID id);

}
