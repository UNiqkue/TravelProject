package com.netcracker.travel.service.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface AbstractService<T> {

    List<T> getAll() throws SQLException;

}
