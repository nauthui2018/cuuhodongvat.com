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
    public Report findById(int id) {
        return reportDao.findById(id);
    }

    @Override
    public void add(Report report) throws SQLException {
        reportDao.add(report);
    }

    @Override
    public boolean update(Report report) throws SQLException {
        return reportDao.update(report);
    }

    @Override
    public boolean delete(Report report) throws SQLException {
        return reportDao.delete(report);
    }

    public List<Report> findReportByName(String name) {
        return reportDao.findReportByName(name);
    }
}
