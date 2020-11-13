package dao;

import model.Article;

import java.util.List;

public interface IArticleDAO extends BaseDAO<Article> {
    public List<Article> selectByTitle(String articleTitle);
    public List<Article> selectByAuthor(String articleAuthor);
    public List<Article> selectBySearchKey(String search);
}
