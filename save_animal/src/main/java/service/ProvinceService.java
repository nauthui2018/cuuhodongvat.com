package com.project.teamLongHuongNguyen.service;

import com.project.teamLongHuongNguyen.dao.ProvinceDao;
import com.project.teamLongHuongNguyen.model.Province;

import java.sql.SQLException;
import java.util.List;

public class ProvinceService implements BaseService<Province> {
    private ProvinceDao provinceDao=new ProvinceDao();
    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public Province findOne(int id) {
        return provinceDao.findOne(id);
    }

    @Override
    public void save(Province province) throws SQLException {

    }

    @Override
    public boolean update(Province province) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
