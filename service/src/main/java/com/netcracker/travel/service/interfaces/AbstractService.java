package com.netcracker.travel.service.interfaces;

import com.netcracker.travel.dto.TourDto;

import java.util.List;
import java.util.UUID;

public interface AbstractService<T> {

    List<T> getAll();

    T getByUsername(String username);

}
