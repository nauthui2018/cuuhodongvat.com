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
    public Donor findById(int id) {
        return donorDao.findById(id);
    }

    @Override
    public void add(Donor donor) throws SQLException {
        donorDao.add(donor);
    }

    @Override
    public boolean update(Donor donor) throws SQLException {
        donorDao.findById(donor.getDonorID());
        return donorDao.update(donor);
    }

    @Override
    public boolean delete(Donor donor) throws SQLException {
        return donorDao.delete(donor);
    }

    public Donor findByDonorName(String donorName) {
        return donorDao.findByDonorName(donorName);
    }

    public List<Donor> findOneByName(String donorName) {
        return donorDao.findOneByName(donorName);
    }
}
