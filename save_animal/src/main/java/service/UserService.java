package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User login(String userUsername, String userPassword) {
        return userDAO.login(userUsername, userPassword);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public boolean checkUsername(String username) {
        return userDAO.checkUsername(username);
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public boolean delete(User user) {
        return userDAO.delete(user);
    }

    public boolean update(User user) {
        return userDAO.update(user);
    }

    public User selectById(int userID) {
        return userDAO.selectById(userID);
    }

    public boolean isAdmin(User user) {
        return userDAO.isAdmin(user);
    }

    public boolean isActive(User user) {
        return userDAO.isActive(user);
    }
}
