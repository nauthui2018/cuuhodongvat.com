package dao;

import model.Activity;

import java.util.List;

public interface IActivityDAO extends BaseDAO<Activity> {
    public List<Activity> selectByTarget(String activityTarget);
    public List<Activity> selectByName(String activityTarget);
}
