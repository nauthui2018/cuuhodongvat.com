package service;

import dao.ArticleDAO;
import model.Article;

import java.util.List;

public class ArticleService implements BaseService<Article>{
    ArticleDAO articleDAO = new ArticleDAO();

    @Override
    public List<Article> findAll() {
        return articleDAO.findAll();
    }

    @Override
    public void add(Article article) {
        articleDAO.add(article);
    }

    @Override
    public boolean delete(Article article) {
        return articleDAO.delete(article);
    }

    @Override
    public boolean update(Article article) {
        return articleDAO.update(article);
    }

    @Override
    public Article findById(int articleID) {
        return articleDAO.findById(articleID);
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
