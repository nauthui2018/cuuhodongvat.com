package controller;

import model.Article;
import model.User;
import service.ArticleService;
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

@WebServlet(name = "ArticleServlet", urlPatterns = "/articles")
public class ArticleServlet extends HttpServlet {
    private ArticleService articleService = new ArticleService();
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
                    addArticle(request, response);
                    break;
                case "update":
                    updateArticle(request, response);
                    break;
                case "delete":
                    deleteArticle(request, response);
                    break;
                case "view":
                    selectArticleById(request, response);
                    break;
                case "selectByName":
                    selectArticleByTitle(request, response);
                    break;
                case "selectByAuthor":
                    selectArticleByAuthor(request, response);
                    break;
                case "selectBySearchKey":
                    selectArticleBySearchKey(request, response);
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
                default:
                    listArticles(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listArticles(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            List<Article> listArticles = articleService.findAll();
            request.setAttribute("listArticles", listArticles);
            dispatcher = request.getRequestDispatcher("views/article/listArticles.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void selectArticleByTitle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            String articleTitle = request.getParameter("articleTitle");
            List<Article> listArticles = articleService.selectByTitle(articleTitle);
            request.setAttribute("listArticles", listArticles);
            request.setAttribute("articleTitle", articleTitle);
            dispatcher = request.getRequestDispatcher("views/article/listArticles.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void selectArticleBySearchKey(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            String searchName = request.getParameter("searchName");
            List<Article> listArticles = articleService.selectBySearchKey(searchName);
            request.setAttribute("listArticles", listArticles);
            request.setAttribute("searchName", searchName);
            dispatcher = request.getRequestDispatcher("views/article/listArticles.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void selectArticleByAuthor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            String articleAuthor = request.getParameter("articleAuthor");
            List<Article> listArticles = articleService.selectByAuthor(articleAuthor);
            request.setAttribute("listArticles", listArticles);
            request.setAttribute("articleAuthor", articleAuthor);
            dispatcher = request.getRequestDispatcher("views/article/listArticles.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void selectArticleById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int articleID = Integer.parseInt(request.getParameter("articleID"));
            Article article = articleService.findById(articleID);
            request.setAttribute("article", article);
            dispatcher = request.getRequestDispatcher("views/article/viewArticle.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            dispatcher = request.getRequestDispatcher("views/article/addArticle.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int articleID = Integer.parseInt(request.getParameter("articleID"));
            Article article = articleService.findById(articleID);
            request.setAttribute("article", article);
            dispatcher = request.getRequestDispatcher("views/article/updateArticle.jsp");
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
            int articleID = Integer.parseInt(request.getParameter("articleID"));
            Article article = articleService.findById(articleID);
            request.setAttribute("article", article);
            dispatcher = request.getRequestDispatcher("views/article/deleteArticle.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            String articleType = request.getParameter("articleType");
            String articleCreatedDate = request.getParameter("articleCreatedDate");
            String articleContent = request.getParameter("articleContent");
            String articleTitle = request.getParameter("articleTitle");
            String articleAuthor = request.getParameter("articleAuthor");
            String articleReference = request.getParameter("articleReference");
            String employeeID = request.getParameter("employeeID");
            Article article = new Article();
            HashMap<String, String> validationResult = new HashMap<>();
            validationResult = article.validationArticle(articleType, articleCreatedDate, articleContent, articleTitle, articleAuthor, articleReference, employeeID);
            if (validationResult.size() == 0) {
                articleService.add(article);
                List<Article> listArticles = articleService.findAll();
                request.setAttribute("listArticles", listArticles);
                request.setAttribute("message", "A new article is added!");
                dispatcher = request.getRequestDispatcher("views/article/listArticles.jsp");
            } else {
                request.setAttribute("validationResult", validationResult);
                request.setAttribute("article", article);
                dispatcher = request.getRequestDispatcher("views/article/addArticle.jsp");
            }
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int articleID = Integer.parseInt(request.getParameter("articleID"));
            String articleType = request.getParameter("articleType");
            String articleCreatedDate = request.getParameter("articleCreatedDate");
            String articleContent = request.getParameter("articleContent");
            String articleTitle = request.getParameter("articleTitle");
            String articleAuthor = request.getParameter("articleAuthor");
            String articleReference = request.getParameter("articleReference");
            String employeeID = request.getParameter("employeeID");
            Article article = new Article();
            HashMap<String, String> validationResult = new HashMap<>();
            validationResult = article.validationArticle(articleType, articleCreatedDate, articleContent, articleTitle, articleAuthor, articleReference, employeeID);
            if (validationResult.size() == 0) {
                article.setArticleID(articleID);
                articleService.update(article);
                List<Article> listArticles = articleService.findAll();
                request.setAttribute("listArticles", listArticles);
                request.setAttribute("message", "A article is updated!");
                dispatcher = request.getRequestDispatcher("views/article/listArticles.jsp");
            } else {
                request.setAttribute("validationResult", validationResult);
                request.setAttribute("article", article);
                dispatcher = request.getRequestDispatcher("views/article/updateArticle.jsp");
            }
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        RequestDispatcher dispatcher;
        if (user != null) {
            int articleID = Integer.parseInt(request.getParameter("articleID"));
            Article article = articleService.findById(articleID);
            articleService.delete(article);
            List<Article> listArticles = articleService.findAll();
            request.setAttribute("listArticles", listArticles);
            request.setAttribute("message", "Article is deleted!");
            dispatcher = request.getRequestDispatcher("views/article/listArticles.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("views/user/login.jsp");
        }
        dispatcher.forward(request, response);
    }
}
