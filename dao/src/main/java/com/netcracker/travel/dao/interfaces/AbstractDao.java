package com.netcracker.travel.dao.interfaces;

import com.netcracker.travel.entity.abstracts.BaseEntity;

import java.util.Collection;
import java.util.UUID;

<<<<<<< HEAD
public interface AbstractDao<T extends BaseEntity> {

    T getById(UUID id);

    Collection<T> getByName(String name);

    Collection<T> getAll();

    T save(T t);

    T update(T t);

=======
public interface AbstractDao<T extends BaseEntity>{

    T getById(UUID id);
    Collection<T> getByName(String name);
    Collection<T> getAll();
    T save(T t);
    T update(T t);
>>>>>>> d177eb1e96c657f9a48464952036b2c59a242ded
    void delete(UUID id);
}
