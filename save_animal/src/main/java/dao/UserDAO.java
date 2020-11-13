package dao;

import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements BaseDAO<User> {
    HelperDAO helper = new HelperDAO();

    public User login(String userUsername, String userPassword) {
        User user = null;
        String query = "{CALL login(?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, userUsername);
            callableStatement.setString(2, userPassword);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                boolean userAdmin = rs.getBoolean("userAdmin");
                boolean userActive = rs.getBoolean("userActive");
                int employeeID = rs.getInt("employeeID");
                user = new User(userID, userUsername, userPassword, userAdmin, userActive, employeeID);
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        String query = "{CALL get_all_users()}";
        List<User> users = new ArrayList<>();
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String userUsername = rs.getString("userUsername");
                String userPassword = rs.getString("userPassword");
                boolean userAdmin = rs.getBoolean("userAdmin");
                boolean userActive = rs.getBoolean("userActive");
                int employeeID = rs.getInt("employeeID");
                users.add(new User(userID, userUsername, userPassword, userAdmin, userActive, employeeID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return users;
    }

    public boolean checkUsername(String username) {
        List<User> users = findAll();
        boolean isExisted = false;
        for (User item: users) {
            if (item.getUserUsername().equals(username)) {
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    @Override
    public void add(User user) {
        String query = "{CALL add_new_user(?,?,?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, user.getUserUsername());
            callableStatement.setString(2, user.getUserPassword());
            callableStatement.setBoolean(3, user.isUserAdmin());
            callableStatement.setBoolean(4, user.isUserActive());
            callableStatement.setInt(5, user.getEmployeeID());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
    }

    @Override
    public boolean delete(User user) {
        String query = "{CALL delete_user(?)}";
        boolean rowDeleted = false;
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, user.getUserID());
            callableStatement.executeUpdate();
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean update(User user) {
        boolean rowUpdated = false;
        String query = "{CALL update_password(?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, user.getUserID());
            callableStatement.setString(2, user.getUserPassword());
            callableStatement.executeUpdate();
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public User selectById(int userID) {
        String query = "{CALL get_user_by_id()}";
        User user = new User();
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                userID = rs.getInt("userID");
                String userUsername = rs.getString("userUsername");
                String userPassword = rs.getString("userPassword");
                boolean userAdmin = rs.getBoolean("userAdmin");
                boolean userActive = rs.getBoolean("userActive");
                int employeeID = rs.getInt("employeeID");
                user = new User(userID, userUsername, userPassword, userAdmin, userActive, employeeID);
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return user;
    }

    public boolean isAdmin(User user) {
        boolean rowUpdated = false;
        String query = "{CALL set_admin(?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, user.getUserID());
            callableStatement.setBoolean(2, user.isUserAdmin());
            callableStatement.executeUpdate();
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowUpdated;
    }

    public boolean isActive(User user) {
        boolean rowUpdated = false;
        String query = "{CALL set_active(?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, user.getUserID());
            callableStatement.setBoolean(2, user.isUserActive());
            callableStatement.executeUpdate();
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowUpdated;
    }
}
