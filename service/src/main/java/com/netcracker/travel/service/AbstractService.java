package com.netcracker.travel.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AbstractService<T> {

    List<T> getAll();

    T getByUsername(String username);

}
