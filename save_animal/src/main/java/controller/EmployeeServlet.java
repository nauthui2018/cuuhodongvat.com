package controller;

import dao.ProvinceDao;
import model.Employee;
import model.Province;
import service.EmployeeService;
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

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService=new EmployeeService();
    private ProvinceDao provinceDao=new ProvinceDao();
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
                    listEmployeeByName(request, response);
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
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> employeeList =employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void view(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.findById(id);
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));

        Employee employee=employeeService.findById(id);

        request.setAttribute("employee",employee);
        request.setAttribute("genderList",new Employee().getGenderList());
        request.setAttribute("degreeList",new Employee().getDegreeList());
        request.setAttribute("positionList",new Employee().getPositionList());

        List<Province> provinceList=provinceDao.findAll();
        request.setAttribute("provinceList",provinceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));

        String employeeName=request.getParameter("employeeName");
        String employeePosition=request.getParameter("employeePosition");
        String employeeGroup=request.getParameter("employeeGroup");
        String employeeDescription=request.getParameter("employeeDescription");

        String date=request.getParameter("employeeDOB");
        Date employeeDOB=Date.valueOf(date);

        String employeeDegree=request.getParameter("employeeDegree");
        String employeeEmail=request.getParameter("employeeEmail");
        String employeePhone=request.getParameter("employeePhone");
        String employeeAddress=request.getParameter("employeeAddress");
        String employeeCMND=request.getParameter("employeeCMND");

        String idProvince=request.getParameter("employeeProvince");
        Province employeeProvince=provinceDao.findById(Integer.parseInt(idProvince));

        String employeeImage=request.getParameter("employeeImage");
        String employeeGender=request.getParameter("employeeGender");

        String joinDate=request.getParameter("employeeJoinDate");
        Date employeeJoinDate=Date.valueOf(joinDate);

        Employee employee=new Employee(id,employeeName,employeePosition,employeeGroup,employeeDescription,employeeDOB,employeeDegree,employeeEmail,employeePhone,employeeAddress,employeeCMND,employeeProvince,employeeImage,employeeGender,employeeJoinDate);

        HashMap<String,String> validate=validateHelper.validationEmployee(employeeName,employeeGender,date,employeePhone,employeeAddress,employeeEmail,idProvince,employeeDescription,employeeImage,joinDate,employeeDegree,employeePosition);

        if (validate.size()>0){
            request.setAttribute("validate",validate);
        }else {
            employeeService.update(employee);
            request.setAttribute("cmt","Employee updated!");
        }

        request.setAttribute("employee",employee);
        request.setAttribute("degreeList",new Employee().getDegreeList());
        request.setAttribute("positionList",new Employee().getPositionList());

        List<Province> provinceList=provinceDao.findAll();
        request.setAttribute("genderList",new Employee().getGenderList());
        request.setAttribute("provinceList",provinceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.findById(id);
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/delete.jsp");
        request.setAttribute("cmt","Bạn có muốn xóa?");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
        response.sendRedirect("/employees");

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Province> provinceList=provinceDao.findAll();
        request.setAttribute("genderList",new Employee().getGenderList());
        request.setAttribute("positionList",new Employee().getPositionList());
        request.setAttribute("degreeList",new Employee().getDegreeList());
        request.setAttribute("provinceList",provinceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String employeeName=request.getParameter("employeeName");
        String employeePosition=request.getParameter("employeePosition");
        String employeeGroup=request.getParameter("employeeGroup");
        String employeeDescription=request.getParameter("employeeDescription");

        String date=request.getParameter("employeeDOB");
        Date employeeDOB=Date.valueOf(date);

        String employeeDegree=request.getParameter("employeeDegree");
        String employeeEmail=request.getParameter("employeeEmail");
        String employeePhone=request.getParameter("employeePhone");
        String employeeAddress=request.getParameter("employeeAddress");
        String employeeCMND=request.getParameter("employeeCMND");

        String id=request.getParameter("employeeProvince");
        Province employeeProvince=provinceDao.findById(Integer.parseInt(id));

        String employeeImage=request.getParameter("employeeImage");
        String employeeGender=request.getParameter("employeeGender");

        String joinDate=request.getParameter("employeeJoinDate");
        Date employeeJoinDate=Date.valueOf(joinDate);

        Employee employee=new Employee(employeeName,employeePosition,employeeGroup,employeeDescription,employeeDOB,employeeDegree,employeeEmail,employeePhone,employeeAddress,employeeCMND,employeeProvince,employeeImage,employeeGender,employeeJoinDate);

        HashMap<String,String> validate=validateHelper.validationEmployee(employeeName,employeeGender,date,employeePhone,employeeAddress,employeeEmail,id
                ,employeeDescription,employeeImage,joinDate,employeeDegree,employeePosition);

        if (validate.size()>0){
            request.setAttribute("validate",validate);
        }else {
            employeeService.add(employee);
            request.setAttribute("cmt","Employee đã được thêm vào danh sách!");
        }

        List<Province> provinceList=provinceDao.findAll();
        request.setAttribute("provinceList",provinceList);
        request.setAttribute("genderList",new Employee().getGenderList());
        request.setAttribute("degreeList",new Employee().getDegreeList());
        request.setAttribute("positionList",new Employee().getPositionList());
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployeeByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String employeeName=request.getParameter("searchName");
        List<Employee> employeeList =employeeService.findByNameEmployee(employeeName);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
