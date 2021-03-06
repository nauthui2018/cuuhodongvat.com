package dao;


import model.Donor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonorDao extends HelperDAO implements BaseDAO<Donor> {
    private static final String SELECT_ALL_DONOR="SELECT * FROM save_animals.donor;";
    private static final String SELECT_DONOR_BY_ID="SELECT * FROM save_animals.donor where donorID=?;";
    private static final String INSERT_NEW_DONOR="INSERT INTO `save_animals`.`donor`(`donorName`,`donorSurrogate`,`donorAddress`,`donorEmail`,`donorPhone`,`donorMoney`,`donorTotalMoney`,`donorImage`)VALUES(?,?,?,?,?,?,?,?);";
    private static final String UPDATE_DONOR="UPDATE `save_animals`.`donor`SET `donorName` = ?,`donorSurrogate` = ?,`donorAddress` = ?,`donorEmail` = ?,`donorPhone` = ?,`donorMoney` = ?,`donorTotalMoney`=?,`donorImage` = ? WHERE `donorID` = ?;";
    private static final String DELETE_DONOR_BY_ID="DELETE FROM `save_animals`.`donor` WHERE donorID=?;";
    private static final String SELECT_DONOR_BY_NAME="SELECT * FROM save_animals.donor where donorName=?;";
    private static final String SEARCH_DONOR_BY_NAME="SELECT * FROM save_animals.donor where donorName like concat('%',?,'%');";


    @Override
    public List<Donor> findAll() {
        List<Donor> donorList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DONOR);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int reportID=rs.getInt("donorID");
                String donorName = rs.getString("donorName");
                String donorSurrogate=rs.getString("donorSurrogate");
                String donorAddress=rs.getString("donorAddress");
                String donorEmail=rs.getString("donorEmail");
                String donorPhone=rs.getString("donorPhone");
                Double donorMoney=rs.getDouble("donorMoney");
                Double donorTotalMoney=rs.getDouble("donorTotalMoney");
                String donorImage=rs.getString("donorImage");
                donorList.add(new Donor(reportID,donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorMoney,donorTotalMoney,donorImage));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donorList;
    }

    @Override
    public Donor findById(int id) {
        Donor donor = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DONOR_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String donorName = rs.getString("donorName");
                String donorSurrogate=rs.getString("donorSurrogate");
                String donorAddress=rs.getString("donorAddress");
                String donorEmail=rs.getString("donorEmail");
                String donorPhone=rs.getString("donorPhone");
                Double donorMoney=rs.getDouble("donorMoney");
                Double donorTotalMoney=rs.getDouble("donorTotalMoney");
                String donorImage=rs.getString("donorImage");
                donor=new Donor(id,donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorMoney,donorTotalMoney,donorImage);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donor;
    }

    @Override
    public void add(Donor donor) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_DONOR)) {
            preparedStatement.setString(1, donor.getDonorName());
            preparedStatement.setString(2, donor.getDonorSurrogate());
            preparedStatement.setString(3, donor.getDonorAddress());
            preparedStatement.setString(4, donor.getDonorEmail());
            preparedStatement.setString(5, donor.getDonorPhone());
            preparedStatement.setDouble(6, donor.getDonorMoney());
            preparedStatement.setDouble(7, donor.getDonorTotalMoney());
            preparedStatement.setString(8, donor.getDonorImage());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Donor donor) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_DONOR);) {
            statement.setString(1, donor.getDonorName());
            statement.setString(2, donor.getDonorSurrogate());
            statement.setString(3, donor.getDonorAddress());
            statement.setString(4, donor.getDonorEmail());
            statement.setString(5, donor.getDonorPhone());
            statement.setDouble(6, donor.getDonorMoney());
            statement.setDouble(7, donor.getDonorTotalMoney());
            statement.setString(8, donor.getDonorImage());
            statement.setInt(9, donor.getDonorID());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(Donor donor) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_DONOR_BY_ID);) {
            statement.setInt(1, donor.getDonorID());
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public Donor findByDonorName(String donorName) {
        Donor donor = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DONOR_BY_NAME);) {
            preparedStatement.setString(1, donorName);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("donorID");
                String donorSurrogate=rs.getString("donorSurrogate");
                String donorAddress=rs.getString("donorAddress");
                String donorEmail=rs.getString("donorEmail");
                String donorPhone=rs.getString("donorPhone");
                Double donorMoney=rs.getDouble("donorMoney");
                Double donorTotalMoney=rs.getDouble("donorTotalMoney");
                String donorImage=rs.getString("donorImage");
                donor=new Donor(id,donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorMoney,donorTotalMoney,donorImage);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donor;
    }

    public List<Donor> findOneByName(String name) {
        List<Donor> donorList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_DONOR_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int donorID=rs.getInt("donorID");
                String donorName = rs.getString("donorName");
                String donorSurrogate=rs.getString("donorSurrogate");
                String donorAddress=rs.getString("donorAddress");
                String donorEmail=rs.getString("donorEmail");
                String donorPhone=rs.getString("donorPhone");
                Double donorMoney=rs.getDouble("donorMoney");
                Double donorTotalMoney=rs.getDouble("donorTotalMoney");
                String donorImage=rs.getString("donorImage");
                donorList.add(new Donor(donorID,donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorMoney,donorTotalMoney,donorImage));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donorList;
    }
}
