package dao;

import model.Activity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO extends HelperDAO implements IActivityDAO {
    HelperDAO helper = new HelperDAO();

    public ActivityDAO() {
    }

    @Override
    public List<Activity> findAll() {
        String query = "{CALL get_all_activities()}";
        List<Activity> activities = new ArrayList<>();
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int activityID = rs.getInt("activityID");
                String activityName = rs.getString("activityName");
                String activityDescription = rs.getString("activityDescription");
                int activityMember = rs.getInt("activityMember");
                String activityTarget = rs.getString("activityTarget");
                int sponsorID = rs.getInt("sponsorID");
                activities.add(new Activity(activityID, activityName, activityDescription, activityMember, activityTarget, sponsorID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return activities;
    }

    @Override
    public void add(Activity activity) {
        String query = "{CALL add_new_activity(?,?,?,?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, activity.getActivityName());
            callableStatement.setString(2, activity.getActivityDescription());
            callableStatement.setInt(3, activity.getActivityMember());
            callableStatement.setString(4, activity.getActivityTarget());
            callableStatement.setInt(5, activity.getSponsorID());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
    }

    @Override
    public boolean delete(Activity activity) {
        String query = "{CALL delete_activity(?)}";
        boolean rowDeleted = false;
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, activity.getActivityID());
            callableStatement.executeUpdate();
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Activity activity) {
        boolean rowUpdated = false;
        String query = "{CALL update_activity(?,?,?,?,?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, activity.getActivityID());
            callableStatement.setString(2, activity.getActivityName());
            callableStatement.setString(3, activity.getActivityDescription());
            callableStatement.setInt(4, activity.getActivityMember());
            callableStatement.setString(5, activity.getActivityTarget());
            callableStatement.setInt(6, activity.getSponsorID());
            callableStatement.executeUpdate();
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public Activity findById(int activityID) {
        Activity activity = null;
        String query = "{CALL get_activity_by_id(?)}";
        try (Connection connection = helper.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, activityID);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                activityID = rs.getInt("activityID");
                String activityName = rs.getString("activityName");
                String activityDescription = rs.getString("activityDescription");
                int activityMember = rs.getInt("activityMember");
                String activityTarget = rs.getString("activityTarget");
                int sponsorID = rs.getInt("sponsorID");
                activity = new Activity(activityID, activityName, activityDescription, activityMember, activityTarget, sponsorID);
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return activity;
    }

    @Override
    public List<Activity> selectByName(String search) {
        List<Activity> activities = new ArrayList<>();
        String query = "{CALL get_activity_by_name(?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, search);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int activityID = rs.getInt("activityID");
                String activityName = rs.getString("activityName");
                String activityDescription = rs.getString("activityDescription");
                int activityMember = rs.getInt("activityMember");
                String activityTarget = rs.getString("activityTarget");
                int sponsorID = rs.getInt("sponsorID");
                activities.add(new Activity(activityID, activityName, activityDescription, activityMember, activityTarget, sponsorID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return activities;
    }

    @Override
    public List<Activity> selectByTarget(String activityTarget) {
        List<Activity> activities = new ArrayList<>();
        String query = "{CALL get_activity_by_target(?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, activityTarget);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int activityID = rs.getInt("activityID");
                String activityName = rs.getString("activityName");
                String activityDescription = rs.getString("activityDescription");
                int activityMember = rs.getInt("activityMember");
                activityTarget = rs.getString("activityTarget");
                int sponsorID = rs.getInt("sponsorID");
                activities.add(new Activity(activityID, activityName, activityDescription, activityMember, activityTarget, sponsorID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return activities;
    }
}
