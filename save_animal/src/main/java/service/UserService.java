package service;

import dao.UserDAO;
import model.Report;
import model.User;

import java.util.List;

public class UserService implements BaseService<User> {
    private UserDAO userDAO = new UserDAO();

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public boolean delete(User user) {
        return userDAO.delete(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public User findById(int userID) {
        return userDAO.findById(userID);
    }

    public boolean isAdmin(User user) {
        return userDAO.isAdmin(user);
    }

    public boolean isActive(User user) {
        return userDAO.isActive(user);
    }

    public boolean checkUsername(String username) {
        return userDAO.checkUsername(username);
    }

    public User login(String userUsername, String userPassword) {
        return userDAO.login(userUsername, userPassword);
    }
}
