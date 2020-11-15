package dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {

    public List<T> findAll() throws Exception;
    public void add(T t) throws Exception;
    public boolean delete(T t) throws Exception;
    public boolean update(T t) throws Exception;
    public T findById(int id) throws Exception;
}
