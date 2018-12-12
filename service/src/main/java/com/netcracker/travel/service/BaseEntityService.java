package com.netcracker.travel.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseEntityService<T> {

    List<T> getAll();

    T getByUsername(String username);

    T getById(String id);

    T save(T t);

    T update(T t);

    void delete(String id);

}
