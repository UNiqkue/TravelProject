package com.netcracker.travel.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T>{

    List<T> getAll();

    T getById(String id);

    T save(T t);

    T update(String id, T t);

    void delete(String id);

}
