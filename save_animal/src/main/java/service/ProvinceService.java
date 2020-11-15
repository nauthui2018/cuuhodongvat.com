package service;


import dao.ProvinceDao;
import model.Province;

import java.sql.SQLException;
import java.util.List;

public class ProvinceService implements BaseService<Province> {
    private ProvinceDao provinceDao=new ProvinceDao();
    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public Province findById(int id) {
        return provinceDao.findById(id);
    }

    @Override
    public void add(Province province) throws SQLException {

    }

    @Override
    public boolean update(Province province) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Province province) throws SQLException {
        return false;
    }
}
