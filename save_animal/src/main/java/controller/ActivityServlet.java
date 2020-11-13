package controller;

import model.Activity;
import model.User;
import service.ActivityService;
import service.UserService;
import service.ValidateHelper;

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

@WebServlet(name = "ActivityServlet", urlPatterns = "/activities")
public class ActivityServlet extends HttpServlet {
    private ActivityService activityService = new ActivityService();
    private UserService userService = new UserService();
    private ValidateHelper validateHelper = new ValidateHelper();

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
                    addActivity(request, response);
                    break;
                case "update":
                    updateActivity(request, response);
                    break;
                case "delete":
                    deleteActivity(request, response);
                    break;
                case "selectById":
                    selectActivityById(request, response);
                    break;
                case "selectByName":
                    selectActivityByName(request, response);
                    break;
                case "selectByTarget":
                    selectActivityByTarget(request, response);
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
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "view":
                    selectActivityById(request, response);
                    break;
                default:
                    listActivities(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listActivities(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            List<Activity> listActivities = activityService.findAll();
            request.setAttribute("listActivities", listActivities);
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void selectActivityByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            String searchName = request.getParameter("searchName");
            List<Activity> listActivities = activityService.selectByName(searchName);
            request.setAttribute("listActivities", listActivities);
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            request.setAttribute("searchName", searchName);
            dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void selectActivityByTarget(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            String activityTarget = request.getParameter("activityTarget");
            List<Activity> listActivities = activityService.selectByTarget(activityTarget);
            request.setAttribute("listActivities", listActivities);
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void selectActivityById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int activityID = Integer.parseInt(request.getParameter("activityID"));
            Activity activity = activityService.selectById(activityID);
            request.setAttribute("activity", activity);
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            dispatcher = request.getRequestDispatcher("views/activity/viewActivity.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            dispatcher = request.getRequestDispatcher("views/activity/addActivity.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            int activityID = Integer.parseInt(request.getParameter("activityID"));
            Activity activity = activityService.selectById(activityID);
            request.setAttribute("activity", activity);
            dispatcher = request.getRequestDispatcher("views/activity/updateActivity.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            int activityID = Integer.parseInt(request.getParameter("activityID"));
            Activity activity = activityService.selectById(activityID);
            request.setAttribute("activity", activity);
            dispatcher = request.getRequestDispatcher("views/activity/deleteActivity.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void addActivity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            String activityName = request.getParameter("activityName");
            String activityDescription = request.getParameter("activityDescription");
            String activityMember = request.getParameter("activityMember");
            String activityTarget = request.getParameter("activityTarget");
            String sponsorID = request.getParameter("sponsorID");
            Activity activity = new Activity();
            HashMap<String, String> validationResult = new HashMap<>();
            validationResult = activity.validationActivity(activityName, activityDescription, activityMember, activityTarget, sponsorID);
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            if (validationResult.size() == 0) {
                activityService.add(activity);
                List<Activity> listActivities = activityService.findAll();
                request.setAttribute("listActivities", listActivities);
                request.setAttribute("message", "A new activity is added!");
                dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
            } else {
                request.setAttribute("validationResult", validationResult);
                request.setAttribute("activity", activity);
                dispatcher = request.getRequestDispatcher("views/activity/addActivity.jsp");
            }
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void updateActivity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int activityID = Integer.parseInt(request.getParameter("activityID"));
            String activityName = request.getParameter("activityName");
            String activityDescription = request.getParameter("activityDescription");
            String activityMember = request.getParameter("activityMember");
            String activityTarget = request.getParameter("activityTarget");
            String sponsorID = request.getParameter("sponsorID");
            Activity activity = new Activity();
            HashMap<String, String> validationResult = new HashMap<>();
            validationResult = activity.validationActivity(activityName, activityDescription, activityMember, activityTarget, sponsorID);
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            if (validationResult.size() == 0) {
                activity.setActivityID(activityID);
                activityService.update(activity);
                List<Activity> listActivities = activityService.findAll();
                request.setAttribute("listActivities", listActivities);
                request.setAttribute("message", "Activity is updated!");
                dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
            } else {
                request.setAttribute("validationResult", validationResult);
                request.setAttribute("activity", activity);
                dispatcher = request.getRequestDispatcher("views/activity/updateActivity.jsp");
            }
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void deleteActivity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int activityID = Integer.parseInt(request.getParameter("activityID"));
            Activity activity = activityService.selectById(activityID);
            activityService.delete(activity);
            List<Activity> listActivities = activityService.findAll();
            request.setAttribute("listActivities", listActivities);
//            List<Sponsor> listSponsors = sponsorService.findAll();
//            request.setAttribute("listSponsors", listSponsors);
            request.setAttribute("message", "Activity is deleted!");
            dispatcher = request.getRequestDispatcher("views/activity/listActivities.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/home.jsp");
        }
        dispatcher.forward(request, response);
    }
}
