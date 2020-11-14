package service;


import dao.DonorDao;
import model.Donor;

import java.sql.SQLException;
import java.util.List;

public class DonorService implements BaseService<Donor> {
    private DonorDao donorDao=new DonorDao();

    @Override
    public List<Donor> findAll() {
        return donorDao.findAll();
    }

    @Override
    public Donor findOne(int id) {
        return donorDao.findOne(id);
    }

    @Override
    public void save(Donor donor) throws SQLException {
        donorDao.save(donor);
    }

    @Override
    public boolean update(Donor donor) throws SQLException {
        donorDao.findOne(donor.getDonorID());
        return donorDao.update(donor);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return donorDao.delete(id);
    }

    public Donor findByDonorName(String donorName) {
        return donorDao.findByDonorName(donorName);
    }

    public List<Donor> findOneByName(String donorName) {
        return donorDao.findOneByName(donorName);
    }
}
