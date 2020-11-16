package controller;

import model.Employee;
import model.User;
import service.EmployeeService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    private EmployeeService employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    addUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    showAddForm(request, response);
                    break;
                case "listUsers":
                    listUsers(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
                case "login":
                    showLoginForm(request, response);
                    break;
                default:
                    home(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String userUsername = request.getParameter("userUsername");
        String userPassword = request.getParameter("userPassword");
        User user = userService.login(userUsername, userPassword);
        RequestDispatcher dispatcher;
        if (userService.checkUsername(userUsername)) {
            if (userService.login(userUsername, userPassword) != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("message", "Welcome back");
                dispatcher = request.getRequestDispatcher("views/home.jsp");
            } else {
                request.setAttribute("userUsername", userUsername);
                request.setAttribute("incorrectPassword", "Incorrect password. Please try again!");
                dispatcher = request.getRequestDispatcher("views/user/login.jsp");
            }
        } else {
            request.setAttribute("userUsername", userUsername);
            request.setAttribute("incorrectUsername", "Invalid username. Please try again!");
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            List<User> listUsers = userService.findAll();
            request.setAttribute("listUsers", listUsers);
            List<Employee> listEmployees = employeeService.findAll();
            request.setAttribute("listEmployees", listEmployees);
            dispatcher = request.getRequestDispatcher("views/user/listUser.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/addUser.jsp");
        dispatcher.forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String userUsername = request.getParameter("userUsername");
        String userPassword = request.getParameter("userPassword");
        request.setAttribute("userUsername", userUsername);
        request.setAttribute("userPassword", userPassword);
        RequestDispatcher dispatcher;
        if (userService.checkUsername(userUsername)) {
            request.setAttribute("message", "This username is existed. Please try other username!");
            dispatcher = request.getRequestDispatcher("views/user/addUser.jsp");
        } else {
            User user = new User();
            HashMap<String, String> validationResult = new HashMap<>();
            validationResult = user.validationUser(userUsername, userPassword);
            if (validationResult.size() == 0) {
                user.setUserAdmin(true);
                user.setUserActive(true);
                userService.add(user);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
            } else {
                request.setAttribute("validationResult", validationResult);
                request.setAttribute("user", user);
                dispatcher = request.getRequestDispatcher("views/user/addUser.jsp");
            }
        }
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("views/user/updateUser.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int userID = user.getUserID();
            String userUsername = user.getUserUsername();
            String currentPassword = request.getParameter("currentPassword");
            String newPassword1 = request.getParameter("newPassword1");
            String newPassword2 = request.getParameter("newPassword2");
            if (user.getUserPassword().equals(currentPassword)) {
                if (newPassword1.equals(newPassword2)) {
                    User newUser = new User();
                    HashMap<String, String> validationResult = new HashMap<>();
                    validationResult = newUser.validationUser(userUsername, newPassword1);
                    if (validationResult.size() == 0) {
                        newUser.setUserAdmin(true);
                        newUser.setUserActive(true);
                        userService.update(newUser);
                        session.setAttribute("user", newUser);
                        dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
                    } else {
                        request.setAttribute("validationResult", validationResult);
                        request.setAttribute("user", newUser);
                        dispatcher = request.getRequestDispatcher("views/user/updateUser.jsp");
                    }
                } else {
                    request.setAttribute("message", "Your passwords are misaligned. Please re-type you password!");
                    request.setAttribute("user", user);
                    dispatcher = request.getRequestDispatcher("views/user/updateUser.jsp");
                }
            } else {
                request.setAttribute("user", user);
                request.setAttribute("message", "Current password is incorrect. Please try again!");
                dispatcher = request.getRequestDispatcher("/views/user/updateUser.jsp");
            }
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("views/user/deleteUser.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            if (user.getUserID() == userID) {
                List<User> listUsers = userService.findAll();
                request.setAttribute("listUsers", listUsers);
                request.setAttribute("message", "This is your account. Please login by another account to delete!");
                dispatcher = request.getRequestDispatcher("views/user/listUser.jsp");
            } else {
                userService.delete(userService.findById(userID));
                List<User> listUsers = userService.findAll();
                request.setAttribute("listUsers", listUsers);
                dispatcher = request.getRequestDispatcher("views/user/listUser.jsp");
            }
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        session.invalidate();
        dispatcher.forward(request, response);
    }
}
