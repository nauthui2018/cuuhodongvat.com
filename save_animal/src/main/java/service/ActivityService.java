package service;

import dao.ActivityDAO;
import model.Activity;

import java.util.List;

public class ActivityService implements BaseService<Activity>{
    private ActivityDAO activityDAO = new ActivityDAO();

    @Override
    public List<Activity> findAll() {
        return activityDAO.findAll();
    }

    @Override
    public void add(Activity activity) {
        activityDAO.add(activity);
    }

    @Override
    public boolean delete(Activity activity) {
        return activityDAO.delete(activity);
    }

    @Override
    public boolean update(Activity activity) {
        return activityDAO.update(activity);
    }

    @Override
    public Activity findById(int activityID) {
        return activityDAO.findById(activityID);
    }

    public List<Activity> selectByName(String search) {
        return activityDAO.selectByName(search);
    }

    public List<Activity> selectByTarget(String activityTarget) {
        return activityDAO.selectByTarget(activityTarget);
    }
}

