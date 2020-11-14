package dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDaoLong<T> {
    List<T> findAll();
    T findOne(int id);
    void save(T e) throws SQLException;
    boolean update(T e) throws SQLException;
    boolean delete(int id) throws SQLException;
}
