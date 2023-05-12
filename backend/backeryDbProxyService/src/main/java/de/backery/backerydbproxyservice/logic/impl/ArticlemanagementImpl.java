package de.backery.backerydbproxyservice.logic.impl;

import de.backery.backerydbproxyservice.dataaccess.entity.ArticleEntity;
import de.backery.backerydbproxyservice.to.ArticleTo;
import de.backery.backerydbproxyservice.dataaccess.repo.ArticleRepository;
import de.backery.backerydbproxyservice.logic.Articlemanagement;
import de.backery.backerydbproxyservice.mapper.CustomMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class ArticlemanagementImpl implements Articlemanagement {

    private final CustomMapper customMapper;
    private final ArticleRepository articleRepository;

    @Override
    public List<ArticleTo> getAllArticles() {
        List<ArticleEntity> allArticleEntity = articleRepository.findAll();
        log.info("Found {} articles", allArticleEntity.size());
        return customMapper.articleEntityListToArticleToList(allArticleEntity);
    }

    @Override
    public ArticleTo createNewArticle(ArticleTo articleTo) {
        ArticleEntity convertedArticle = customMapper.articleToToArticleEntity(articleTo);
        convertedArticle.setArticleId(UUID.randomUUID().toString());
        ArticleEntity savedArticle = articleRepository.save(convertedArticle);
        log.info("The article with id {} has been created", savedArticle.getArticleId());
        return customMapper.articleEntityToArticleTo(savedArticle);
    }

    @Override
    public Optional<ArticleTo> getArticleByArticleId(String articleId) {
        ArticleEntity foundArticleEntity;
        Optional<ArticleEntity> optionalArticleEntity = Optional.of(articleRepository.findByArticleId(articleId));
        if (optionalArticleEntity.isPresent()) {
            foundArticleEntity = optionalArticleEntity.get();
            log.info("Found article with id {}", foundArticleEntity.getArticleId());
            return Optional.of(customMapper.articleEntityToArticleTo(foundArticleEntity));
        }
        return Optional.empty();
    }

    @Override
    public ArticleTo updateArticle(ArticleTo reqArticleTo) {
        Optional<ArticleTo> reqArticle = Optional.ofNullable(reqArticleTo);
        if (reqArticle.isPresent()) {
            ArticleEntity foundArticleEntity =
                    articleRepository.findByArticleId(reqArticle.get().getArticleId());
            ArticleEntity changedEntity = articleRepository.save(ArticleEntity
                    .builder()
                    .id(foundArticleEntity.getId())
                    .articleId(foundArticleEntity.getArticleId())
                    .name(reqArticleTo.getName())
                    .description(reqArticleTo.getDescription())
                    .build()
            );
            log.info("Article with id {} has been updated", changedEntity.getArticleId());
            return customMapper.articleEntityToArticleTo(changedEntity);
        }
        return null;
    }

    @Override
    public ArticleTo deleteArticle(String articleId) {
        ArticleEntity toBeDeletedArticle =
                articleRepository.findByArticleId(articleId);
        if (toBeDeletedArticle != null) {
            articleRepository.delete(toBeDeletedArticle);
            log.info("Article with id {} has been deleted", toBeDeletedArticle.getArticleId());
            return customMapper.articleEntityToArticleTo(toBeDeletedArticle);
        }
        return null;
    }
}
