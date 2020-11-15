package controller;


import model.Report;
import service.ReportService;
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

@WebServlet(name = "ReportServlet",urlPatterns = "/reports")
public class ReportServlet extends HttpServlet {
    private ReportService reportService=new ReportService();

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
                case "status":
                    status(request,response);
                    break;
                case "search":
                    listReportByName(request, response);
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
                    listReport(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void listReport(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Report> reportList = reportService.findAll();
        request.setAttribute("reportList", reportList);
        request.setAttribute("statusList",new Report().getStatusList());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/list.jsp");
        dispatcher.forward(request, response);
    }

    private void status(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));

        String status=request.getParameter("reportStatus");

        Report report=reportService.findById(id);
        report.setReportStatus(status);
        reportService.update(report);
        response.sendRedirect("/reports");
    }

    private void view(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Report report=reportService.findById(id);
        request.setAttribute("report",report);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Report report=reportService.findById(id);
        request.setAttribute("report",report);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        String reportAddress=request.getParameter("reportAddress");
        String reportDescription=request.getParameter("reportDescription");
        String reportPersonName=request.getParameter("reportPersonName");
        String reportEmail=request.getParameter("reportEmail");
        String reportPhone=request.getParameter("reportPhone");

        String reportStatus=reportService.findById(id).getReportStatus();

        Report report=new Report(id,reportAddress,reportDescription,reportPersonName,reportEmail,reportPhone,reportStatus);

        HashMap<String,String> validate=validateHelper.validationReport(reportPersonName,reportAddress,reportEmail,reportPhone,reportDescription);

        if (validate.size()>0){
            request.setAttribute("validate",validate);
        }else {
            reportService.update(report);
            request.setAttribute("cmt","Report updated!");
        }
        request.setAttribute("report",report);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Report report=reportService.findById(id);
        request.setAttribute("report",report);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/delete.jsp");
        request.setAttribute("cmt","Bạn có muốn xóa?");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("reportID"));
        Report report=reportService.findById(id);
        if (report.getReportStatus().equals("Xong rồi")){
            reportService.delete(report);
            response.sendRedirect("/reports");
        }else {
            request.setAttribute("report",report);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/delete.jsp");
            request.setAttribute("cmt","Report chưa làm hoặc đang làm nên không thể xóa?");
            dispatcher.forward(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/create.jsp");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String reportAddress=request.getParameter("reportAddress");
        String reportDescription=request.getParameter("reportDescription");
        String reportPersonName=request.getParameter("reportPersonName");
        String reportEmail=request.getParameter("reportEmail");
        String reportPhone=request.getParameter("reportPhone");
        String reportStatus="Chưa làm";
        Report report=new Report(reportAddress,reportDescription,reportPersonName,reportEmail,reportPhone,reportStatus);

        HashMap<String,String> validate=validateHelper.validationReport(reportPersonName,reportAddress,reportEmail,reportPhone,reportDescription);

        if (validate.size()>0){
            request.setAttribute("validate",validate);
        }else {
            reportService.add(report);
            request.setAttribute("cmt","Report đã được thêm vào danh sách");
        }
        request.setAttribute("report",report);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listReportByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String reportName=request.getParameter("searchName");
        List<Report> reportList = reportService.findReportByName(reportName);
        request.setAttribute("reportList", reportList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/report/list.jsp");
        dispatcher.forward(request, response);
    }

}
