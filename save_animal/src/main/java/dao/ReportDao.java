package dao;


import model.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDao extends HelperDAO implements BaseDAO<Report> {
    private static final String SELECT_ALL_REPORT="SELECT * FROM savinganimal.reports;";
    private static final String SELECT_REPORT_BY_ID ="SELECT * FROM savinganimal.reports where reportID=?;";
    private static final String INSERT_NEW_REPORT ="INSERT INTO `savinganimal`.`reports`(`reportAddress`,`reportDescription`,`reportPersonName`,`reportEmail`,`reportPhone`,`reportStatus`)VALUES(?,?,?,?,?,?);";
    private static final String UPDATE_REPORT ="UPDATE `savinganimal`.`reports` SET`reportAddress` = ?,`reportDescription` = ?,`reportPersonName` = ?,`reportEmail` = ?,`reportPhone` = ?,`reportStatus` = ? WHERE `reportID` = ?;";
    private static final String DELETE_REPORT_BY_ID ="DELETE FROM `savinganimal`.`reports` WHERE reportID=?;";
    private static final String SELECT_REPORT_BY_NAME ="SELECT * FROM savinganimal.reports where reportPersonName like concat('%',?,'%');";



    public List<Report> findAll() {
        List<Report> reportList = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REPORT);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int reportID=rs.getInt("reportID");
                String reportAddress = rs.getString("reportAddress");
                String reportDescription=rs.getString("reportDescription");
                String reportPersonName=rs.getString("reportPersonName");
                String reportEmail=rs.getString("reportEmail");
                String reportPhone=rs.getString("reportPhone");
                String reportStatus=rs.getString("reportStatus");
                reportList.add(new Report(reportID,reportAddress,reportDescription,reportPersonName,reportEmail,reportPhone,reportStatus));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return reportList;
    }

    public Report findById(int id) {
        Report report = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REPORT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String reportAddress = rs.getString("reportAddress");
                String reportDescription=rs.getString("reportDescription");
                String reportPersonName=rs.getString("reportPersonName");
                String reportEmail=rs.getString("reportEmail");
                String reportPhone=rs.getString("reportPhone");
                String reportStatus=rs.getString("reportStatus");
                report=new Report(id,reportAddress,reportDescription,reportPersonName,reportEmail,reportPhone,reportStatus);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return report;
    }

    public void add(Report report)throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_REPORT)) {
            preparedStatement.setString(1, report.getReportAddress());
            preparedStatement.setString(2, report.getReportDescription());
            preparedStatement.setString(3, report.getReportPersonName());
            preparedStatement.setString(4, report.getReportEmail());
            preparedStatement.setString(5, report.getReportPhone());
            preparedStatement.setString(6, report.getReportStatus());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public boolean update(Report report) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_REPORT);) {
            statement.setString(1, report.getReportAddress());
            statement.setString(2, report.getReportDescription());
            statement.setString(3, report.getReportPersonName());
            statement.setString(4, report.getReportEmail());
            statement.setString(5, report.getReportPhone());
            statement.setString(6, report.getReportStatus());
            statement.setInt(7, report.getReportID());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean delete(Report report)throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_REPORT_BY_ID);) {
            statement.setInt(1, report.getReportID());
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<Report> findReportByName(String name) {
        List<Report> reportList = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REPORT_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int reportID=rs.getInt("reportID");
                String reportAddress = rs.getString("reportAddress");
                String reportDescription=rs.getString("reportDescription");
                String reportPersonName=rs.getString("reportPersonName");
                String reportEmail=rs.getString("reportEmail");
                String reportPhone=rs.getString("reportPhone");
                String reportStatus=rs.getString("reportStatus");
                reportList.add(new Report(reportID,reportAddress,reportDescription,reportPersonName,reportEmail,reportPhone,reportStatus));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return reportList;
    }

}
