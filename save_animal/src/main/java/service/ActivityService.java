package service;

import dao.ActivityDAO;
import model.Activity;

import java.util.List;

public class ActivityService {
    private ActivityDAO activityDAO = new ActivityDAO();

    public List<Activity> findAll() {
        return activityDAO.findAll();
    }

    public void add(Activity activity) {
        activityDAO.add(activity);
    }

    public boolean delete(Activity activity) {
        return activityDAO.delete(activity);
    }

    public boolean update(Activity activity) {
        return activityDAO.update(activity);
    }

    public Activity selectById(int activityID) {
        return activityDAO.selectById(activityID);
    }

    public List<Activity> selectByName(String search) {
        return activityDAO.selectByName(search);
    }

    public List<Activity> selectByTarget(String activityTarget) {
        return activityDAO.selectByTarget(activityTarget);
    }
}

