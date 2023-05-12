package de.backery.backerydbproxyservice.service.impl;

import de.backery.backerydbproxyservice.to.ArticleTo;
import de.backery.backerydbproxyservice.logic.Articlemanagement;
import de.backery.backerydbproxyservice.service.ArticlemanagementRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class ArticlemanagementRestServiceImpl implements ArticlemanagementRestService {

    private final Articlemanagement articlemanagement;

    @Override
    public List<ArticleTo> getAllArticles() {
        return articlemanagement.getAllArticles();
    }

    @Override
    public ResponseEntity<ArticleTo> createArticle(ArticleTo article) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(articlemanagement.createNewArticle(article));
    }

    @Override
    public ResponseEntity<ArticleTo> getArticleById(String articleId) {
        ArticleTo foundArticle = articlemanagement
                .getArticleByArticleId(articleId)
                .orElse(null);
        return generateArticleToResponse(foundArticle);
    }

    @Override
    public ResponseEntity<ArticleTo> updateArticle(String articleId, ArticleTo article) {
        ArticleTo updatedArticle = articlemanagement.updateArticle(article);
        return generateArticleToResponse(updatedArticle);
    }

    @Override
    public ResponseEntity<ArticleTo> deleteArticle(String articleId) {
        ArticleTo deletedArticle = articlemanagement.deleteArticle(articleId);
        return generateArticleToResponse(deletedArticle);
    }

    private ResponseEntity<ArticleTo> generateArticleToResponse(ArticleTo articleTo) {
        if (articleTo != null) {
            return ResponseEntity.ok(articleTo);
        }
        return ResponseEntity.notFound().build();
    }
}
