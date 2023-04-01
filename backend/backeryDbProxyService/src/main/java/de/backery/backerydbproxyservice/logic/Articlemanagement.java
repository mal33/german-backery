package de.backery.backerydbproxyservice.logic;

import de.backery.backerydbproxyservice.to.ArticleTo;

import java.util.List;

public interface Articlemanagement {

    List<ArticleTo> getAllArticles();
    ArticleTo createNewArticle(ArticleTo articleTo);
    ArticleTo getArticleByArticleId(String articleId);
    ArticleTo updateArticle(ArticleTo articleTo);
    ArticleTo deleteArticle(String articleId);
}
