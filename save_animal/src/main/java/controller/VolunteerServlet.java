package controller;

import dao.VolunteersDAO;
import model.Animals;
import model.Volunteers;
import service.ValidateHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "VolunteerServlet", urlPatterns = "/volunteer")
public class VolunteerServlet extends HttpServlet {
    private VolunteersDAO volunteersDAO;
    private ValidateHelper validateHelper=new ValidateHelper();

    public void init() {
        volunteersDAO = new VolunteersDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    insertVolunteer(request, response);
                    break;
                case "update":
                    updateVolunteer(request, response);
                    break;
                case "search":
                    searchWithNameOfVolunteer(request, response);
                    break;
//                case "status":
//                    exchangeStatus(request,response);
//                    break;
                case "delete":
                    deleteVolunteer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void exchangeStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        int id=Integer.parseInt(request.getParameter("id"));
//
//        int status= Integer.parseInt(request.getParameter("status"));
//        Volunteers volunteers=volunteersDAO.findById(id);
//        volunteers.setStatus(status);
////        reportService.update(report);
//        response.sendRedirect("/volunteer");
//    }






    private void deleteVolunteer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Volunteers volunteer = volunteersDAO.findById(id);
        volunteersDAO.delete(volunteer);
        List<Volunteers> volunteers = volunteersDAO.findAll();
        request.setAttribute("volunteer", volunteers);
        request.setAttribute("message", "Volunteer is deleted!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/list.jsp");
        dispatcher.forward(request, response);
    }

//    private void searchUserByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("search");
//        List<Producer> producers = producerDAO.s(name);
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        User account = (User) session.getAttribute("user");
//        if (account != null) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "add":
                    showNewForm(request, response);
                    break;
                case "update":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "view":
                    showViewVolunteer(request, response);
                    break;
                case "list":
                    break;
                default:
                    listVolunteers(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        } else {
//            response.sendRedirect("view/admin_view/dist/login.jsp");
//        }
    }


    private void searchWithNameOfVolunteer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("search");
        List<Volunteers> volunteers = volunteersDAO.searchWithName(name);
        request.setAttribute("volunteer", volunteers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/list.jsp");
        dispatcher.forward(request, response);


    }

    private void showViewVolunteer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Volunteers volunteers = volunteersDAO.findById(id);
        request.setAttribute("volunteer", volunteers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/view.jsp");
        dispatcher.forward(request, response);
    }

//    private void sortUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Producer> producers = producerDAO.sortAllUsers();
//        request.setAttribute("listUser", producers);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//
//    }

    private void listVolunteers(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Volunteers> volunteer = volunteersDAO.findAll();
        request.setAttribute("volunteer", volunteer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Volunteers volunteer = volunteersDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/update.jsp");
        request.setAttribute("volunteer", volunteer);
        dispatcher.forward(request, response);

    }

    private void insertVolunteer(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String dateOfBirthString = request.getParameter("dateOfBirth");
        int address = Integer.parseInt(request.getParameter("addres"));
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String image = request.getParameter("image");
        String personalCode = request.getParameter("personalCode");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String registrationProgram = request.getParameter("registrationProgram");
        String reasonForRegistration = request.getParameter("reasonForRegistration");
        int status = 1;
        Volunteers volunteer = new Volunteers(firstName, lastName, dateOfBirth, address, mobile, email, image, personalCode, gender, registrationProgram, reasonForRegistration,status);
        HashMap<String, String> validate = validateHelper.validationVolunteer(firstName, lastName, dateOfBirthString, mobile, email);
        if (validate.size() > 0) {
            request.setAttribute("validate", validate);
        } else {
            volunteersDAO.add(volunteer);
            request.setAttribute("message", "A new Volunteer is Added");
        }
        List<Volunteers> volunteers = volunteersDAO.findAll();
        request.setAttribute("volunteer", volunteers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateVolunteer(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String dateOfBirthString = request.getParameter("dateOfBirth");
        int address = Integer.parseInt(request.getParameter("address"));
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String image = request.getParameter("image");
        String personalCode = request.getParameter("personalCode");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int status = Integer.parseInt(request.getParameter("status"));
        String registrationProgram = request.getParameter("registrationProgram");
        String reasonForRegistration = request.getParameter("reasonForRegistration");
        Volunteers volunteer = new Volunteers(id, firstName, lastName, dateOfBirth, address, mobile, email, image, personalCode, gender, registrationProgram, reasonForRegistration,status);
        HashMap<String, String> validate = validateHelper.validationVolunteer(firstName, lastName, dateOfBirthString, mobile, email);
        if (validate.size() > 0) {
            request.setAttribute("validate", validate);
        } else {
            volunteersDAO.update(volunteer);
            request.setAttribute("message", "Volunteer is Updated");
        }
        List<Volunteers> volunteers = volunteersDAO.findAll();
        request.setAttribute("volunteer", volunteers);
//        request.setAttribute("type", type);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Volunteers volunteers = volunteersDAO.findById(id);

//        animalsDAO.delete(id);
//        List<Animals> animal = animalsDAO.getAll();
        request.setAttribute("volunteer", volunteers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/volunteer/delete.jsp");
        dispatcher.forward(request, response);
    }
}
