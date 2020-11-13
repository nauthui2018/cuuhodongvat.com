package model;

import service.ValidateHelper;

import java.util.HashMap;

public class Activity {
    private int activityID;
    private String activityName;
    private String activityDescription;
    private int activityMember;
    private String activityTarget;
    private int sponsorID;
    private ValidateHelper validateHelper = new ValidateHelper();

    public Activity() {
    }

    public Activity(int activityID, String activityName, String activityDescription, int activityMember, String activityTarget, int sponsorID) {
        this.activityID = activityID;
        this.activityName = activityName;
        this.activityDescription = activityDescription;
        this.activityMember = activityMember;
        this.activityTarget = activityTarget;
        this.sponsorID = sponsorID;
    }

    public HashMap<String, String> validationActivity(String activityName, String activityDescription, String activityMember, String activityTarget, String sponsorID) {
        HashMap<String, String> validationResult = new HashMap<>();
        if (validateHelper.validateShortText(activityName)) {
            setActivityName(activityName);
        } else {
            validationResult.put("activityName", "'" + activityName + "' - Invalid text");
        }
        if (validateHelper.validateLongText(activityDescription)) {
            setActivityDescription(activityDescription);
        } else {
            validationResult.put("activityDescription", "'" + activityDescription + "' - Invalid text");
        }
        if (validateHelper.validateIntegerNumber(activityMember)) {
            setActivityMember(Integer.parseInt(activityMember));
        } else {
            validationResult.put("activityMember", "'" + activityMember + "' - Invalid number");
        }
        if (validateHelper.validateShortText(activityTarget)) {
            setActivityTarget(activityTarget);
        } else {
            validationResult.put("activityTarget", "'" + activityTarget + "' - Invalid text");
        }
        if (validateHelper.validateIntegerNumber(sponsorID)) {
            setSponsorID(Integer.parseInt(sponsorID));
        } else {
            validationResult.put("sponsorID", "Please select sponsor");
        }
        return validationResult;
    }

    public int getActivityID() {
        return activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public int getActivityMember() {
        return activityMember;
    }

    public String getActivityTarget() {
        return activityTarget;
    }

    public int getSponsorID() {
        return sponsorID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public void setActivityMember(int activityMember) {
        this.activityMember = activityMember;
    }

    public void setActivityTarget(String activityTarget) {
        this.activityTarget = activityTarget;
    }

    public void setSponsorID(int sponsorID) {
        this.sponsorID = sponsorID;
    }
}
