package dao;

import model.Activity;

import java.util.List;

public interface IActivityDAO extends BaseDAO<Activity> {
    public List<Activity> selectByTarget(String activityTarget) throws Exception;
    public List<Activity> selectByName(String activityTarget) throws Exception;
}
