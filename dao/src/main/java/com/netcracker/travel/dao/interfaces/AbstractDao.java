package com.netcracker.travel.dao.interfaces;

import com.netcracker.travel.entity.abstracts.BaseEntity;

import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

public interface AbstractDao<T extends BaseEntity>{

  /*  Map<UUID, ? extends BaseEntity> entityMap = new HashMap<>();

    Collection<T> getEntityMapValues();*/
    T getById(UUID id) throws SQLException;
   // Collection<T> getByName(String name);
    Collection<T> getAll() throws SQLException;
 //   void save(T t) throws SQLException; //не забыть про Tпоставить
    T update(T t) throws SQLException;
    void delete(UUID id) throws SQLException;
}
