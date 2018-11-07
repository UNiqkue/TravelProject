package com.netcracker.travel.dao.interfaces;

import com.netcracker.travel.entity.abstracts.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface AbstractDao<T extends BaseEntity>{

    T getById(UUID id);
    T getByName(String name);
    List<T> getAll();
    T save(T t);
    void update(T t);
    void delete(UUID id);
}
