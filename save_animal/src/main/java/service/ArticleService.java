package service;

import dao.ArticleDAO;
import model.Article;

import java.util.List;

public class ArticleService {
    ArticleDAO articleDAO = new ArticleDAO();

    public List<Article> findAll() {
        return articleDAO.findAll();
    }

    public void add(Article article) {
        articleDAO.add(article);
    }

    public boolean delete(Article article) {
        return articleDAO.delete(article);
    }

    public boolean update(Article article) {
        return articleDAO.update(article);
    }

    public Article selectById(int articleID) {
        return articleDAO.selectById(articleID);
    }

    public List<Article> selectByTitle(String title) {
        return articleDAO.selectByTitle(title);
    }

    public List<Article> selectByAuthor(String articleAuthor) {
        return articleDAO.selectByAuthor(articleAuthor);
    }

    public List<Article> selectBySearchKey(String search) {
        return articleDAO.selectBySearchKey(search);
    }
}
