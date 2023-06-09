package de.backery.backerydbproxyservice.logic;

import de.backery.backerydbproxyservice.to.ArticleTo;

import java.util.List;
import java.util.Optional;

public interface Articlemanagement {

    List<ArticleTo> getAllArticles();
    ArticleTo createNewArticle(ArticleTo articleTo);
    Optional<ArticleTo> getArticleByArticleId(String articleId);
    ArticleTo updateArticle(ArticleTo articleTo);
    ArticleTo deleteArticle(String articleId);
}
