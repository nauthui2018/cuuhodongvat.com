package model;

import service.ValidateHelper;

import java.util.HashMap;

public class User  {
    private int userID;
    private String userUsername;
    private String userPassword;
    private boolean userAdmin;
    private boolean userActive;
    private int employeeID;

    private ValidateHelper validateHelper = new ValidateHelper();

    public User() {
    }

    public User(int userID, String userUsername, String userPassword, boolean userAdmin, boolean userActive, int employeeID) {
        this.userID = userID;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userAdmin = userAdmin;
        this.userActive = userActive;
        this.employeeID = employeeID;
    }

    public HashMap<String, String> validationUser(String userUsername, String userPassword) {
        HashMap<String, String> validationResult = new HashMap<>();
        if (validateHelper.validateShortText(userUsername)) {
            setUserUsername(userUsername);
        } else {
            validationResult.put("userUsername", "'" + userUsername + "' - Invalid userUsername");
        }
        if (validateHelper.validateShortText(userPassword)) {
            setUserPassword(userPassword);
        } else {
            validationResult.put("userPassword", "'" + userPassword + "' - Invalid password");
        }
        return validationResult;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public boolean isUserAdmin() {
        return userAdmin;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserAdmin(boolean userAdmin) {
        this.userAdmin = userAdmin;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
