package dao;

import model.Animals;
import model.Volunteers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolunteersDAO extends HelperDAO implements BaseDAO<Volunteers> {

    private static final String INSERT_VOLUNTEER_SQL = "INSERT INTO volunteers" + "  (volunteerFirstName, volunteerLastName, volunteerDOB,volunteerAddresID,volunteerMobile,volunteerEmail,volunteerImage,volunteerPersonalCode,volunteerGender,volunteerRegistrationProgram,volunteerReasonForRegistration,volunteerStatus) VALUES " +
            " (?, ?, ?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_VOLUNTEER_BY_ID = "select * from volunteers where volunteerID =?";
    private static final String SELECT_ALL_VOLUNTEER = "select * from volunteers";
    private static final String DELETE_VOLUNTEER_SQL = "delete from volunteers where volunteerID = ?;";
    private static final String UPDATE_VOLUNTEER_SQL = "update volunteers set volunteerFirstName = ?,volunteerLastName= ?, volunteerDOB =?,volunteerAddresID=?,volunteerMobile=?,volunteerEmail=?,volunteerImage=?,volunteerPersonalCode=?,volunteerGender=?,volunteerRegistrationProgram=?,volunteerReasonForRegistration=?,volunteerStatus=? where volunteerID = ?;";
    private static final String SORT_ALL_VOLUNTEER = "SELECT * from volunteers order by volunteerFirstName ASC;";
    private static final String SEARCH_WITH_NAME = "SELECT * from volunteers where concat(volunteerFirstName,' ',volunteerLastName) LIKE concat('%',?,'%') ;";

    @Override
    public List<Volunteers> findAll() throws Exception {
        List<Volunteers> volunteers = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VOLUNTEER);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("volunteerID");
                String firstName = rs.getString("volunteerFirstName");
                String lastName = rs.getString("volunteerLastName");
                Date dob = rs.getDate("volunteerDOB");
                int addres = Integer.parseInt(rs.getString("volunteerAddresID"));
                String mobile = rs.getString("volunteerMobile");
                String email = rs.getString("volunteerEmail");
                String image = rs.getString("volunteerImage");
                String personalCode = rs.getString("volunteerPersonalCode");
                int gender = rs.getInt("volunteerGender");
                String registrationProgram = rs.getString("volunteerRegistrationProgram");
                String reasonForRegistration = rs.getString("volunteerReasonForRegistration");
                int status = rs.getInt("volunteerStatus");
                volunteers.add(new Volunteers(id, firstName, lastName, dob, addres, mobile, email, image, personalCode, gender, registrationProgram, reasonForRegistration, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return volunteers;
    }

    @Override
    public void add(Volunteers volunteers) throws Exception {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VOLUNTEER_SQL)) {
            preparedStatement.setString(1, volunteers.getFirstName());
            preparedStatement.setString(2, volunteers.getLastName());
            preparedStatement.setDate(3, (java.sql.Date) volunteers.getDateOfBirth());
            preparedStatement.setInt(4, volunteers.getAddress());
            preparedStatement.setString(5, volunteers.getMobile());
            preparedStatement.setString(6, volunteers.getEmail());
            preparedStatement.setString(7, volunteers.getImage());
            preparedStatement.setString(8, volunteers.getPersonalCode());
            preparedStatement.setInt(9, volunteers.getGender());
            preparedStatement.setString(10, volunteers.getRegistrationProgram());
            preparedStatement.setString(11, volunteers.getReasonForRegistration());
            preparedStatement.setInt(12, volunteers.getStatus());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    @Override
    public boolean update(Volunteers volunteers) throws Exception {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_VOLUNTEER_SQL);) {
            statement.setString(1, volunteers.getFirstName());
            statement.setString(2, volunteers.getLastName());
            statement.setDate(3, (java.sql.Date) volunteers.getDateOfBirth());
            statement.setInt(4, volunteers.getAddress());
            statement.setString(5, volunteers.getMobile());
            statement.setString(6, volunteers.getEmail());
            statement.setString(7, volunteers.getImage());
            statement.setString(8, volunteers.getPersonalCode());
            statement.setInt(9, volunteers.getGender());
            statement.setString(10, volunteers.getRegistrationProgram());
            statement.setString(11, volunteers.getReasonForRegistration());
            statement.setInt(12, volunteers.getStatus());
            statement.setInt(13, volunteers.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    @Override
    public boolean delete(Volunteers volunteers) throws Exception {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_VOLUNTEER_SQL);) {
            statement.setInt(1, volunteers.getId());
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Volunteers findById(int id) throws Exception {
        Volunteers volunteer = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOLUNTEER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("volunteerFirstName");
                String lastName = rs.getString("volunteerLastName");
                Date dob = rs.getDate("volunteerDOB");
                int addres = Integer.parseInt(rs.getString("volunteerAddresID"));
                String mobile = rs.getString("volunteerMobile");
                String email = rs.getString("volunteerEmail");
                String image = rs.getString("volunteerImage");
                String personalCode = rs.getString("volunteerPersonalCode");
                int gender = rs.getInt("volunteerGender");
                String registrationProgram = rs.getString("volunteerRegistrationProgram");
                String reasonForRegistration = rs.getString("volunteerReasonForRegistration");
                int status = rs.getInt("volunteerStatus");
                volunteer = new Volunteers(id, firstName, lastName, dob, addres, mobile, email, image, personalCode, gender, registrationProgram, reasonForRegistration, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return volunteer;
    }

    public List<Volunteers> searchWithName(String nameOfVolunteer) {
        List<Volunteers> volunteers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_WITH_NAME)) {
            preparedStatement.setString(1, nameOfVolunteer);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("volunteerID");
                String firstName = rs.getString("volunteerFirstName");
                String lastName = rs.getString("volunteerLastName");
                Date dob = rs.getDate("volunteerDOB");
                int addres = Integer.parseInt(rs.getString("volunteerAddresID"));
                String mobile = rs.getString("volunteerMobile");
                String email = rs.getString("volunteerEmail");
                String image = rs.getString("volunteerImage");
                String personalCode = rs.getString("volunteerPersonalCode");
                int gender = rs.getInt("volunteerGender");
                String registrationProgram = rs.getString("volunteerRegistrationProgram");
                String reasonForRegistration = rs.getString("volunteerReasonForRegistration");
                int status = rs.getInt("volunteerStatus");
                Volunteers volunteer = new Volunteers(id, firstName, lastName, dob, addres, mobile, email, image, personalCode, gender, registrationProgram, reasonForRegistration, status);

                volunteers.add(volunteer);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return volunteers;
    }
}




