package com.netcracker.travel.service.interfaces;

import java.util.List;

public interface AbstractService<T> {

    List<T> getAll();
    T getByUsername(String username);

}
