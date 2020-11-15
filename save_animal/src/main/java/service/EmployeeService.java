package service;


import dao.EmployeeDao;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements BaseService<Employee> {
    private EmployeeDao employeeDao=new EmployeeDao();

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public void add(Employee employee) throws SQLException {
            employeeDao.add(employee);
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(Employee employee) throws SQLException {
        return employeeDao.delete(employee);
    }

    public List<Employee> findByNameEmployee(String name) {
        return employeeDao.findByNameEmployee(name);
    }
}
