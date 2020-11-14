package com.project.teamLongHuongNguyen.service;

import java.sql.SQLException;
import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findOne(int id);
    void save(T e) throws SQLException;
    boolean update(T e) throws SQLException;
    boolean delete(int id) throws SQLException;
}
