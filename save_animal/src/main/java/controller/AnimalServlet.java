package controller;

import dao.AnimalsDAO;
import model.Animals;
import service.ValidateHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AnimalServlet", urlPatterns = "/animal")
public class AnimalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnimalsDAO animalsDAO;
    private ValidateHelper validateHelper=new ValidateHelper();

    public void init() {

        animalsDAO = new AnimalsDAO();
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
                    insertAnimal(request, response);
                    break;
                case "update":
                    updateAnimal(request, response);
                    break;
                case "search":
                    searchAnimal(request, response);
                    break;
                case "delete":
                    deleteAnimal(request, response);
                    break;
                case "searchProtectionLevel":
                    searchProtectionLevel(request, response);
                    break;


            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchProtectionLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("protectionLevelID"));
        List<Animals> animalsList = animalsDAO.selectByProtectionLevel(id);
        request.setAttribute("animal", animalsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/list.jsp");
        dispatcher.forward(request, response);
    }


    private void searchAnimal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Animals> animalsList = animalsDAO.searchWithName(name);
        request.setAttribute("animal", animalsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/list.jsp");
        dispatcher.forward(request, response);

    }
//      response.setContentType("text/html;charset=UTF-8");
//    HttpSession session = request.getSession();
//    User account = (User) session.getAttribute("user");
//        if (account != null) {
//        String action = request.getParameter("action");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
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
                case "view":
                    showViewAnimal(request, response);
                    break;
                case "sort":
//                    sortUser(request, response);
                    break;
                case "paging":
//                        listPaging(request,response);
                    break;

                default:
                    listAnimal(request, response);
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


//    private void listPaging(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String index =request.getParameter("index");
//        if (index==null){
//            index="1";
//        }
//        int indexPage = Integer.parseInt(index);
//        List<Product> productList = productDAO.getPaging(indexPage);
//        request.setAttribute("productList",productList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/dist/productList.jsp");
//        dispatcher.forward(request, response);
//
//    }

//    private void sortUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Producer> producers = producerDAO.sortAllUsers();
//        request.setAttribute("listUser", producers);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//
//    }

    private void listAnimal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Animals> animal = animalsDAO.findAll();
        request.setAttribute("animal", animal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//        List<Animals> animal = animalsDAO.getAll();
//        request.setAttribute("animal", animal);
//        List<Producer> producers = new ProducerDAO().getAll();
//        request.setAttribute("producers", producers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Animals animal = animalsDAO.findById(id);
        request.setAttribute("animal", animal);
//        List<Type> typeList = typeDAO.getAll();
//        request.setAttribute("typeList", typeList);
//        List<Producer> producerList = producerDAO.getAll();
//        request.setAttribute("producerList", producerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/update.jsp");
        dispatcher.forward(request, response);

    }


    private void insertAnimal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int protectionLevel = Integer.parseInt(request.getParameter("protectionLevel"));
        int staffID = Integer.parseInt(request.getParameter("staffID"));
        Animals animal = new Animals(name, image, description, protectionLevel, staffID);

        HashMap<String,String> validate = validateHelper.validationAnimal(name,description);
        if (validate.size()>0) {
            request.setAttribute("validate",validate);
        }else {
            animalsDAO.add(animal);
            request.setAttribute("message", "A new Animal is added!");
        }
//        List<Type> typeList = typeDAO.getAll();
//        request.setAttribute("typeList", typeList);
        List<Animals> animals = animalsDAO.findAll();
        request.setAttribute("animal", animals);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateAnimal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int protectionLevel = Integer.parseInt(request.getParameter("protectionLevel"));
        int staffID = Integer.parseInt(request.getParameter("staffID"));
        Animals animal = new Animals(id, name, image, description, protectionLevel, staffID);
        HashMap<String,String> validate = validateHelper.validationAnimal(name,description);
        if (validate.size()>0) {
            request.setAttribute("validate",validate);
        }else {
            animalsDAO.update(animal);
            request.setAttribute("message", "Animal is updated!");
        }
//        request.setAttribute("animal", animal);
        List<Animals> animals = animalsDAO.findAll();
        request.setAttribute("animal", animals);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteAnimal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Animals animals = animalsDAO.findById(id);
        animalsDAO.delete(animals);
        List<Animals> animal = animalsDAO.findAll();
        request.setAttribute("animal", animal);
        request.setAttribute("message", "Animal is deleted!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/list.jsp");
        dispatcher.forward(request, response);

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Animals animal = animalsDAO.findById(id);

//        animalsDAO.delete(id);
//        List<Animals> animal = animalsDAO.getAll();
        request.setAttribute("animal", animal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void showViewAnimal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Animals animal = animalsDAO.findById(id);
        request.setAttribute("animal", animal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/animal/view.jsp");
        dispatcher.forward(request, response);
    }
}
