package com.netcracker.travel.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CrudTourService<T> {

    T createTour(T t);

    List<T> getExistenceTours();

    List<T> watchTours();

    void deleteTour(UUID id);

    T makeDiscount(UUID id, Double price);

    T editTour(UUID id, String description);

}
