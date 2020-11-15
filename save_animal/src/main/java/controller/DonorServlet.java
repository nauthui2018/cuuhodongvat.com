package controller;


import model.Donor;
import service.DonorService;
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

@WebServlet(name = "DonorServlet",urlPatterns = "/donors")
public class DonorServlet extends HttpServlet {
    private DonorService donorService=new DonorService();
    private ValidateHelper validateHelper=new ValidateHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "update":
                    update(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "create":
                    create(request, response);
                    break;
                case "search":
                    listDonorsByName(request, response);
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
                case "create":
                    showFormCreate(request, response);
                    break;
                case "delete":
                    showFormDelete(request, response);
                    break;
                case "edit":
                    showFormEdit(request, response);
                    break;
                case "view":
                    view(request, response);
                    break;
                default:
                    listDonors(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listDonors(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Donor> donorList = donorService.findAll();
        request.setAttribute("donorList", donorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/list.jsp");
        dispatcher.forward(request, response);
    }

    private void view(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id=Integer.parseInt(request.getParameter("id"));
        Donor donor= donorService.findById(id);
        request.setAttribute("donor",donor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Donor donor=donorService.findById(id);
        request.setAttribute("donor",donor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        String donorName=request.getParameter("donorName");
        String donorSurrogate=request.getParameter("donorSurrogate");
        String donorAddress=request.getParameter("donorAddress");
        String donorEmail=request.getParameter("donorEmail");
        String donorPhone=request.getParameter("donorPhone");
        String money=request.getParameter("donorMoney");
        Double donorMoney=Double.parseDouble(money);

        Double donorTotalMoney=donorMoney;
        String donorImage=request.getParameter("donorImage");

        Donor donor=new Donor(id,donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorMoney,donorTotalMoney,donorImage);
        HashMap<String ,String> validate=validateHelper.validationDonor(donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorImage,money);

        if (validate.size()>0){
            request.setAttribute("validate",validate);
        }else {
            donorService.update(donor);
            request.setAttribute("cmt","Donor updated!");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/edit.jsp");
        request.setAttribute("donor",donor);

        dispatcher.forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Donor donor=donorService.findById(id);
        request.setAttribute("donor",donor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/delete.jsp");
        request.setAttribute("cmt","Bạn có muốn xóa?");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Donor donor=donorService.findById(id);
        donorService.delete(donor);
        response.sendRedirect("/donors");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/create.jsp");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String donorName=request.getParameter("donorName");

        Donor donor=donorService.findByDonorName(donorName);
        if (donor==null){

            String donorSurrogate=request.getParameter("donorSurrogate");
            String donorAddress=request.getParameter("donorAddress");
            String donorEmail=request.getParameter("donorEmail");
            String donorPhone=request.getParameter("donorPhone");

            String money=request.getParameter("donorMoney");
            Double donorMoney=Double.parseDouble(money);

            Double donorTotalMoney=donorMoney;
            String donorImage=request.getParameter("donorImage");

            Donor newDonor=new Donor(donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorMoney,donorTotalMoney,donorImage);

            HashMap<String ,String> validate=validateHelper.validationDonor(donorName,donorSurrogate,donorAddress,donorEmail,donorPhone,donorImage,money);

            if (validate.size()>0){
                request.setAttribute("validate",validate);
            }else {
                donorService.add(newDonor);
                request.setAttribute("cmt","Donor đã được thêm vào danh sách");
            }
            request.setAttribute("donor",newDonor);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/create.jsp");
            dispatcher.forward(request, response);

        }else {
            request.setAttribute("donor",donor);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/editCu.jsp");
            request.setAttribute("cmt","Donor đã từng tài trợ cho nhóm bạn có muốn update không?");
            dispatcher.forward(request, response);
        }
    }

    private void listDonorsByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String donorName=request.getParameter("searchName");
        List<Donor> donorList = donorService.findOneByName(donorName);
        request.setAttribute("donorList", donorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donor/list.jsp");
        dispatcher.forward(request, response);
    }
}
