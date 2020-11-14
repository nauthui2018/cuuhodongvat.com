package com.project.teamLongHuongNguyen.service;

import com.project.teamLongHuongNguyen.dao.EmployeeDao;
import com.project.teamLongHuongNguyen.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements BaseService<Employee> {
    private EmployeeDao employeeDao=new EmployeeDao();

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findOne(int id) {
        return employeeDao.findOne(id);
    }

    @Override
    public void save(Employee employee) throws SQLException {
            employeeDao.save(employee);
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return employeeDao.delete(id);
    }

    public List<Employee> findByNameEmployee(String name) {
        return employeeDao.findByNameEmployee(name);
    }
}
