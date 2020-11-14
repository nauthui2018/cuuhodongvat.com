package service;


import dao.ReportDao;
import model.Report;

import java.sql.SQLException;
import java.util.List;

public class ReportService implements BaseService<Report> {

    private ReportDao reportDao=new ReportDao();

    @Override
    public List<Report> findAll() {
        return reportDao.findAll();
    }

    @Override
    public Report findOne(int id) {
        return reportDao.findOne(id);
    }

    @Override
    public void save(Report report) throws SQLException {
        reportDao.save(report);
    }

    @Override
    public boolean update(Report report) throws SQLException {
        return reportDao.update(report);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return reportDao.delete(id);
    }

    public List<Report> findReportByName(String name) {
        return reportDao.findReportByName(name);
    }
}
