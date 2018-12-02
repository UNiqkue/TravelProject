package com.netcracker.travel.dao.interfaces;

import com.netcracker.travel.entity.abstracts.BaseEntity;

import java.util.Collection;
import java.util.UUID;

public interface AbstractDao<T extends BaseEntity> {

    T getById(UUID id);
<<<<<<< HEAD

    Collection<T> getByName(String name);

    Collection<T> getAll();

    T save(T t);

    T update(T t);

    void delete(UUID id);

=======

    Collection<T> getByName(String name);

    Collection<T> getAll();

    T save(T t);

    T update(T t);

    void delete(UUID id);
>>>>>>> task3
}
