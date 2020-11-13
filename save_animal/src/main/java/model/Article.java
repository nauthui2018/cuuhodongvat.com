package model;

import service.ValidateHelper;

import java.util.HashMap;

public class Article {
    private int articleID;
    private String articleImage;
    private String articleCreatedDate;
    private String articleContent;
    private String articleTitle;
    private String articleAuthor;
    private String articleReference;
    private int employeeID;
    private ValidateHelper validateHelper = new ValidateHelper();

    public Article() {
    }

    public Article(int articleID, String articleImage, String articleCreatedDate, String articleContent, String articleTitle, String articleAuthor, String articleReference, int employeeID) {
        this.articleID = articleID;
        this.articleImage = articleImage;
        this.articleCreatedDate = articleCreatedDate;
        this.articleContent = articleContent;
        this.articleTitle = articleTitle;
        this.articleAuthor = articleAuthor;
        this.articleReference = articleReference;
        this.employeeID = employeeID;
    }

    public HashMap<String, String> validationArticle(String articleType, String articleCreatedDate, String articleContent, String articleTitle, String articleAuthor, String articleReference, String employeeID) {
        HashMap<String, String> validationResult = new HashMap<>();
        if (validateHelper.validateFirstName(articleType)) {
            setArticleImage(articleType);
        } else {
            validationResult.put("articleType", "'" + articleType + "' - Invalid article type");
        }
        if (validateHelper.validateDate(articleCreatedDate)) {
            setArticleCreatedDate(articleCreatedDate);
        } else {
            validationResult.put("articleCreatedDate", "'" + articleCreatedDate + "' - Invalid date");
        }
        if (validateHelper.validateFirstName(articleContent)) {
            setArticleContent(articleContent);
        } else {
            validationResult.put("articleContent", "'" + articleContent + "' - Invalid article content");
        }
        if (validateHelper.validateFirstName(articleTitle)) {
            setArticleTitle(articleTitle);
        } else {
            validationResult.put("articleTitle", "'" + articleTitle + "' - Invalid article title");
        }
        if (validateHelper.validateFirstName(articleAuthor)) {
            setArticleAuthor(articleAuthor);
        } else {
            validationResult.put("articleAuthor", "'" + articleAuthor + "' - Invalid author name");
        }
        if (validateHelper.validateFirstName(articleAuthor)) {
            setArticleAuthor(articleAuthor);
        } else {
            validationResult.put("articleAuthor", "'" + articleAuthor + "' - Invalid author name");
        }
        if (validateHelper.validateShortText(articleReference)) {
            setArticleReference(articleReference);
        } else {
            validationResult.put("articleReference", "'" + articleReference + "' - Invalid reference");
        }
        if (validateHelper.validateIntegerNumber(employeeID)) {
            setEmployeeID(Integer.parseInt(employeeID));
        } else {
            validationResult.put("provinceID", "Please select your province");
        }
        return validationResult;
    }

    public int getArticleID() {
        return articleID;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public String getArticleCreatedDate() {
        return articleCreatedDate;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public String getArticleReference() {
        return articleReference;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public void setArticleCreatedDate(String articleCreatedDate) {
        this.articleCreatedDate = articleCreatedDate;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public void setArticleReference(String articleReference) {
        this.articleReference = articleReference;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
