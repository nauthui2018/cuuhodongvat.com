package dao;

import model.Article;

import java.util.List;

public interface IArticleDAO extends BaseDAO<Article> {
    public List<Article> selectByTitle(String articleTitle) throws Exception;
    public List<Article> selectByAuthor(String articleAuthor) throws Exception;
    public List<Article> selectBySearchKey(String search) throws Exception;
}
