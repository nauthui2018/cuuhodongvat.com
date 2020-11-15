package dao;

import model.Subcribers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubcribersDAO extends HelperDAO implements BaseDAO<Subcribers> {
    private static final String INSERT_SUBCRIBER_SQL = "INSERT INTO subcribers" + "  (subcriberFirstName, subcriberLastName, subcriberEmail,subcriberMobile) VALUES " +
            " (?, ?, ?,?);";
    private static final String SELECT_SUBCRIBER_BY_ID = "select * from subcribers where subcriberID =?";
    private static final String SELECT_ALL_SUBCRIBER = "select * from subcribers";
    private static final String DELETE_SUBCRIBER_SQL = "delete from subcribers where subcriberID = ?;";
    private static final String UPDATE_SUBCRIBER_SQL = "update subcribers set subcriberFirstName = ?,subcriberLastName= ?, subcriberEmail =?,subcriberMobile=? where subcriberID = ?;";
    private static final String SORT_ALL_SUBCRIBER = "SELECT * from subcribers order by subcriberFirstName ASC;";
    private static final String SEARCH_WITH_NAME = "SELECT * from subcribers where concat(subcriberFirstName,' ',subcriberLastName) LIKE concat('%',?,'%');";
    private static final String VIEW_LIST_APPROVED= "select * from subcribers where subcriberStatus =approved;";
    @Override
    public List<Subcribers> findAll() throws Exception {
        List<Subcribers> subcribers = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUBCRIBER);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("subcriberID");
                String firstName = rs.getString("subcriberFirstName");
                String lastName = rs.getString("subcriberLastName");
                String email = rs.getString("subcriberEmail");
                String mobile = rs.getString("subcriberMobile");
                subcribers.add(new Subcribers(id, firstName, lastName, email, mobile));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return subcribers;
    }


    @Override
    public void add(Subcribers subcribers) throws Exception {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUBCRIBER_SQL)) {
            preparedStatement.setString(1, subcribers.getFirstName());
            preparedStatement.setString(2, subcribers.getLastName());
            preparedStatement.setString(3, subcribers.getEmail());
            preparedStatement.setString(4, subcribers.getMobile());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public boolean update(Subcribers subcribers) throws Exception {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SUBCRIBER_SQL);) {
            statement.setString(1, subcribers.getFirstName());
            statement.setString(2, subcribers.getLastName());
            statement.setString(3, subcribers.getEmail());
            statement.setString(4, subcribers.getMobile());
            statement.setInt(5, subcribers.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    @Override
    public boolean delete(Subcribers subcribers) throws Exception {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SUBCRIBER_SQL);) {
            statement.setInt(1, subcribers.getId());
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Subcribers findById(int id) throws Exception {
        Subcribers subcriber = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUBCRIBER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String firstName = rs.getString("subcriberFirstName");
                String lastName = rs.getString("subcriberLastName");
                String email = rs.getString("subcriberEmail");
                String mobile = rs.getString("subcriberMobile");
                subcriber = new Subcribers(id, firstName, lastName, email, mobile);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return subcriber;
    }

    public List<Subcribers> searchWithName(String nameOfSubcriber) {
        List<Subcribers> subcribers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_WITH_NAME)) {
            preparedStatement.setString(1, nameOfSubcriber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("subcriberID");
                String firstName = rs.getString("subcriberFirstName");
                String lastName = rs.getString("subcriberLastName");
                String email = rs.getString("subcriberEmail");
                String mobile = rs.getString("subcriberMobile");

                Subcribers subcriber = new Subcribers(id, firstName, lastName, email, mobile);
                subcribers.add(subcriber);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return subcribers;
    }

    public List<Subcribers> listApproved() {
        List<Subcribers> subcribers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VIEW_LIST_APPROVED)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("subcriberID");
                String firstName = rs.getString("subcriberFirstName");
                String lastName = rs.getString("subcriberLastName");
                String email = rs.getString("subcriberEmail");
                String mobile = rs.getString("subcriberMobile");
                Subcribers subcriber = new Subcribers(id, firstName, lastName, email, mobile);
                subcribers.add(subcriber);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return subcribers;
    }


}

