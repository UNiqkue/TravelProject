package com.netcracker.travel.dao.interfaces;

import com.netcracker.travel.entity.abstracts.BaseEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface AbstractDao<T extends BaseEntity>{

    Map<UUID, ? extends BaseEntity> entityMap = new HashMap<>();

    Collection<T> getEntityMapValues();
    T getById(UUID id);
    Collection<T> getByName(String name);
    Collection<T> getAll();
    void save(T t);
    T update(T t);
    void delete(UUID id);
}
