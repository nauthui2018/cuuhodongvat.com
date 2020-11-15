package controller;

import dao.SubcribersDAO;
import model.Subcribers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SubcriberServlet", urlPatterns = "/subcriber")
public class SubcriberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SubcribersDAO subcribersDAO;


    public void init() {

        subcribersDAO = new SubcribersDAO();
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
                    insertSubcriber(request, response);
                    break;
                case "update":
                    updateSubcriber(request, response);
                    break;
                case "delete":
                    deleteSubcriber(request, response);
                    break;
                case "search":
                    searchWithNameOfSubcriber(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteSubcriber(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Subcribers subcribers = subcribersDAO.findById(id);
        subcribersDAO.delete(subcribers);
        List<Subcribers> subcriber = subcribersDAO.findAll();
        request.setAttribute("subcriber", subcriber);
        request.setAttribute("message", "Subcriber is deleted!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchWithNameOfSubcriber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Subcribers> subcribers = subcribersDAO.searchWithName(name);
        request.setAttribute("subcriber", subcribers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/list.jsp");
        dispatcher.forward(request, response);

    }
//      response.setContentType("text/html;charset=UTF-8");
//    HttpSession session = request.getSession();
//    User account = (User) session.getAttribute("user");
//        if (account != null) {
//        String action = request.getParameter("action");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        User account = (User) session.getAttribute("user");
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
                case "list":
                    listSubcriber(request, response);
//
                    break;
                case "view":
                    viewSubcriber(request, response);
                    break;

                default:
//                        listPaging(request,response);
                    listSubcriber(request, response);
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




    private void viewSubcriber(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));
        Subcribers subcribers = subcribersDAO.findById(id);
        request.setAttribute("subcriber", subcribers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/view.jsp");
        dispatcher.forward(request, response);
    }


//    private void sortUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Producer> producers = producerDAO.sortAllUsers();
//        request.setAttribute("listUser", producers);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//
//    }

    private void listSubcriber(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Subcribers> subcriber = subcribersDAO.findAll();
        request.setAttribute("subcriber", subcriber);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Subcribers subcriber = subcribersDAO.findById(id);
        request.setAttribute("subcriber", subcriber);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/update.jsp");
        dispatcher.forward(request, response);
    }

    private void insertSubcriber(HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        Subcribers subcriber = new Subcribers(firstName, lastName, email, mobile);
        subcribersDAO.add(subcriber);
        List<Subcribers> subcribers = subcribersDAO.findAll();
        request.setAttribute("subcriber", subcribers);
        request.setAttribute("message", "A new Subcriber is added!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateSubcriber(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        Subcribers subcriber = new Subcribers(id, firstName, lastName, email, mobile);
        subcribersDAO.update(subcriber);

        List<Subcribers> subcribers = subcribersDAO.findAll();
        request.setAttribute("subcriber", subcribers);
        request.setAttribute("message", "Subcriber is updated!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/list.jsp");
        dispatcher.forward(request, response);

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Subcribers subcriber = subcribersDAO.findById(id);
        request.setAttribute("subcriber", subcriber);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subcriber/delete.jsp");
        dispatcher.forward(request, response);


    }
}
