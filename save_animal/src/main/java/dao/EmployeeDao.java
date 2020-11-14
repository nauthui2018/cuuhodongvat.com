package dao;


import model.Employee;
import model.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends DAOHelper implements BaseDaoLong<Employee> {
    private ProvinceDao provinceDao=new ProvinceDao();

    private static final String SELECT_ALL_EMPLOYEE ="SELECT * FROM savinganimal.employee;";
    private static final String SELECT_EMPLOYEE_BY_ID ="SELECT * FROM savinganimal.employee where employeeID=? ;";
    private static final String INSERT_NEW_EMPLOYEE="INSERT INTO `savinganimal`.`employee`(`employeeName`,`employeePosition`,`employeeGroup`,`employeeDescription`,`employeeDOB`,`employeeDegree`,`employeeEmail`,`employeePhone`,`employeeAddress`,`employeeCMND`,`employeeProvinceCode`,`employeeImage`,`employeeGender`,`employeeJoinDate`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEE_BY_ID="UPDATE `savinganimal`.`employee` SET `employeeName` = ?,`employeePosition` = ?,`employeeGroup` = ?,`employeeDescription` = ?,`employeeDOB` = ?,`employeeDegree` = ?,`employeeEmail` = ?,`employeePhone` = ?,`employeeAddress` = ?,`employeeCMND` = ?,`employeeProvinceCode` = ?,`employeeImage` = ?,`employeeGender` = ?,`employeeJoinDate` = ? WHERE `employeeID` = ?;";
    private static final String DELETE_EMPLOYEE_BY_ID="DELETE FROM `savinganimal`.`employee` WHERE employeeID=?;";
    private static final String SELECT_ALL_EMPLOYEE_BY_NAME ="SELECT * FROM savinganimal.employee where employeeName like concat('%',?,'%') ;";



    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int employeeID=rs.getInt("employeeID");
                String employeeName = rs.getString("employeeName");
                String employeePosition=rs.getString("employeePosition");
                String employeeGroup=rs.getString("employeeGroup");
                String employeeDescription=rs.getString("employeeDescription");
                Date employeeDOB=Date.valueOf(rs.getString("employeeDOB"));
                String employeeDegree=rs.getString("employeeDegree");
                String employeeEmail=rs.getString("employeeEmail");
                String employeePhone=rs.getString("employeePhone");
                String employeeAddress=rs.getString("employeeAddress");
                String employeeCMND=rs.getString("employeeCMND");
                Province province=provinceDao.findOne(rs.getInt("employeeProvinceCode"));
                String employeeImage=rs.getString("employeeImage");
                String employeeGender=rs.getString("employeeGender");
                Date employeeJoinDate=Date.valueOf(rs.getString("employeeJoinDate"));
                employeeList.add(new Employee(employeeID,employeeName,employeePosition,employeeGroup,employeeDescription,employeeDOB,employeeDegree,employeeEmail,employeePhone,employeeAddress,employeeCMND,province,employeeImage,employeeGender,employeeJoinDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public Employee findOne(int id) {
        Employee employee = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String employeeName = rs.getString("employeeName");
                String employeePosition=rs.getString("employeePosition");
                String employeeGroup=rs.getString("employeeGroup");
                String employeeDescription=rs.getString("employeeDescription");
                Date employeeDOB=Date.valueOf(rs.getString("employeeDOB"));
                String employeeDegree=rs.getString("employeeDegree");
                String employeeEmail=rs.getString("employeeEmail");
                String employeePhone=rs.getString("employeePhone");
                String employeeAddress=rs.getString("employeeAddress");
                String employeeCMND=rs.getString("employeeCMND");
                Province province=provinceDao.findOne(rs.getInt("employeeProvinceCode"));
                String employeeImage=rs.getString("employeeImage");
                String employeeGender=rs.getString("employeeGender");
                Date employeeJoinDate=Date.valueOf(rs.getString("employeeJoinDate"));
                employee=new Employee(id,employeeName,employeePosition,employeeGroup,employeeDescription,employeeDOB,employeeDegree,employeeEmail,employeePhone,employeeAddress,employeeCMND,province,employeeImage,employeeGender,employeeJoinDate);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeePosition());
            preparedStatement.setString(3, employee.getEmployeeGroup());
            preparedStatement.setString(4, employee.getEmployeeDescription());
            preparedStatement.setDate(5, (Date) employee.getEmployeeDOB());
            preparedStatement.setString(6, employee.getEmployeeDegree());
            preparedStatement.setString(7, employee.getEmployeeEmail());
            preparedStatement.setString(8, employee.getEmployeePhone());
            preparedStatement.setString(9, employee.getEmployeeAddress());
            preparedStatement.setString(10, employee.getEmployeeCMND());
            preparedStatement.setInt(11, employee.getEmployeeProvince().getProvinceID());
            preparedStatement.setString(12, employee.getEmployeeImage());
            preparedStatement.setString(13, employee.getEmployeeGender());
            preparedStatement.setDate(14, (Date) employee.getEmployeeJoinDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeePosition());
            preparedStatement.setString(3, employee.getEmployeeGroup());
            preparedStatement.setString(4, employee.getEmployeeDescription());
            preparedStatement.setDate(5, (Date) employee.getEmployeeDOB());
            preparedStatement.setString(6, employee.getEmployeeDegree());
            preparedStatement.setString(7, employee.getEmployeeEmail());
            preparedStatement.setString(8, employee.getEmployeePhone());
            preparedStatement.setString(9, employee.getEmployeeAddress());
            preparedStatement.setString(10, employee.getEmployeeCMND());
            preparedStatement.setInt(11, employee.getEmployeeProvince().getProvinceID());
            preparedStatement.setString(12, employee.getEmployeeImage());
            preparedStatement.setString(13, employee.getEmployeeGender());
            preparedStatement.setDate(14, (Date) employee.getEmployeeJoinDate());
            preparedStatement.setInt(15, employee.getEmployeeID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


    public List<Employee> findByNameEmployee(String name) {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int employeeID=rs.getInt("employeeID");
                String employeeName = rs.getString("employeeName");
                String employeePosition=rs.getString("employeePosition");
                String employeeGroup=rs.getString("employeeGroup");
                String employeeDescription=rs.getString("employeeDescription");
                Date employeeDOB=Date.valueOf(rs.getString("employeeDOB"));
                String employeeDegree=rs.getString("employeeDegree");
                String employeeEmail=rs.getString("employeeEmail");
                String employeePhone=rs.getString("employeePhone");
                String employeeAddress=rs.getString("employeeAddress");
                String employeeCMND=rs.getString("employeeCMND");
                Province province=provinceDao.findOne(rs.getInt("employeeProvinceCode"));
                String employeeImage=rs.getString("employeeImage");
                String employeeGender=rs.getString("employeeGender");
                Date employeeJoinDate=Date.valueOf(rs.getString("employeeJoinDate"));
                employeeList.add(new Employee(employeeID,employeeName,employeePosition,employeeGroup,employeeDescription,employeeDOB,employeeDegree,employeeEmail,employeePhone,employeeAddress,employeeCMND,province,employeeImage,employeeGender,employeeJoinDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
    }
}
