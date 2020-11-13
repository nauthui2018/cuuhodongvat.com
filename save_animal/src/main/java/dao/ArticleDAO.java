package dao;

import model.Article;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO implements IArticleDAO {
    HelperDAO helper = new HelperDAO();

    public ArticleDAO() {
    }

    @Override
    public List<Article> findAll() {
        String query = "{CALL get_all_articles()}";
        List<Article> articles = new ArrayList<>();
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int articleID = rs.getInt("articleID");
                String articleImage = rs.getString("articleImage");
                String articleCreatedDate = rs.getString("articleCreatedDate");
                String articleContent = rs.getString("articleContent");
                String articleTitle = rs.getString("articleTitle");
                String articleAuthor = rs.getString("articleAuthor");
                String articleReference = rs.getString("articleReference");
                int employeeID = rs.getInt("employeeID");
                articles.add(new Article(articleID, articleImage, articleCreatedDate, articleContent, articleTitle, articleAuthor, articleReference, employeeID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return articles;
    }

    @Override
    public void add(Article article) {
        String query = "{CALL add_new_article(?,?,?,?,?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, article.getArticleImage());
            callableStatement.setString(2, article.getArticleCreatedDate());
            callableStatement.setString(3, article.getArticleContent());
            callableStatement.setString(4, article.getArticleTitle());
            callableStatement.setString(5, article.getArticleAuthor());
            callableStatement.setString(6, article.getArticleReference());
            callableStatement.setInt(7, article.getEmployeeID());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
    }

    @Override
    public boolean delete(Article article) {
        String query = "{CALL delete_article(?)}";
        boolean rowDeleted = false;
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, article.getArticleID());
            callableStatement.executeUpdate();
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Article article) {
        boolean rowUpdated = false;
        String query = "{CALL update_article(?,?,?,?,?,?,?,?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, article.getArticleID());
            callableStatement.setString(2, article.getArticleImage());
            callableStatement.setString(3, article.getArticleCreatedDate());
            callableStatement.setString(4, article.getArticleContent());
            callableStatement.setString(5, article.getArticleTitle());
            callableStatement.setString(6, article.getArticleAuthor());
            callableStatement.setString(7, article.getArticleReference());
            callableStatement.setInt(8, article.getEmployeeID());
            callableStatement.executeUpdate();
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public Article selectById(int articleID) {
        Article article = null;
        String query = "{CALL get_article_by_id(?)}";
        try (Connection connection = helper.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, articleID);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                articleID = rs.getInt("articleID");
                String articleImage = rs.getString("articleImage");
                String articleCreatedDate = rs.getString("articleCreatedDate");
                String articleContent = rs.getString("articleContent");
                String articleTitle = rs.getString("articleTitle");
                String articleAuthor = rs.getString("articleAuthor");
                String articleReference = rs.getString("articleReference");
                int employeeID = rs.getInt("employeeID");
                article = new Article(articleID, articleImage, articleCreatedDate, articleContent, articleTitle, articleAuthor, articleReference, employeeID);
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return article;
    }

    @Override
    public List<Article> selectByTitle(String title) {
        List<Article> articles = new ArrayList<>();
        String query = "{CALL get_article_by_title(?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, title);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int articleID = rs.getInt("articleID");
                String articleImage = rs.getString("articleImage");
                String articleCreatedDate = rs.getString("articleCreatedDate");
                String articleContent = rs.getString("articleContent");
                String articleTitle = rs.getString("articleTitle");
                String articleAuthor = rs.getString("articleAuthor");
                String articleReference = rs.getString("articleReference");
                int employeeID = rs.getInt("employeeID");
                articles.add(new Article(articleID, articleImage, articleCreatedDate, articleContent, articleTitle, articleAuthor, articleReference, employeeID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return articles;
    }

    @Override
    public List<Article> selectByAuthor(String articleAuthor) {
        List<Article> articles = new ArrayList<>();
        String query = "{CALL get_article_by_author(?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, articleAuthor);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int articleID = rs.getInt("articleID");
                String articleImage = rs.getString("articleImage");
                String articleCreatedDate = rs.getString("articleCreatedDate");
                String articleContent = rs.getString("articleContent");
                String articleTitle = rs.getString("articleTitle");
                articleAuthor = rs.getString("articleAuthor");
                String articleReference = rs.getString("articleReference");
                int employeeID = rs.getInt("employeeID");
                articles.add(new Article(articleID, articleImage, articleCreatedDate, articleContent, articleTitle, articleAuthor, articleReference, employeeID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return articles;
    }

    @Override
    public List<Article> selectBySearchKey(String search) {
        List<Article> articles = new ArrayList<>();
        String query = "{CALL get_article_by_search_key(?)}";
        try (Connection connection = helper.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, search);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int articleID = rs.getInt("articleID");
                String articleImage = rs.getString("articleImage");
                String articleCreatedDate = rs.getString("articleCreatedDate");
                String articleContent = rs.getString("articleContent");
                String articleTitle = rs.getString("articleTitle");
                String articleAuthor = rs.getString("articleAuthor");
                String articleReference = rs.getString("articleReference");
                int employeeID = rs.getInt("employeeID");
                articles.add(new Article(articleID, articleImage, articleCreatedDate, articleContent, articleTitle, articleAuthor, articleReference, employeeID));
            }
        } catch (SQLException e) {
            helper.printSQLException(e);
        }
        return articles;
    }
}
