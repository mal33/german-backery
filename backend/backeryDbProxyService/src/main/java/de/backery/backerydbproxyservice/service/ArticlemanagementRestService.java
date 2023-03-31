package de.backery.backerydbproxyservice.service;

import de.backery.backerydbproxyservice.to.ArticleTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public interface ArticlemanagementRestService {

    @GetMapping("/articles")
    List<ArticleTo> getAllArticles();

    @PostMapping("/articles")
    ResponseEntity<ArticleTo> createArticle(@RequestBody ArticleTo article);

    @GetMapping("/articles/{articleId}")
    ResponseEntity<ArticleTo> getArticleById(@PathVariable(value = "articleId") String articleId);

    @PutMapping("/articles/{articleId}")
    ResponseEntity<ArticleTo> updateArticle(@PathVariable(value = "articleId") String articleId,
                                          @RequestBody ArticleTo article);

    @DeleteMapping("/articles/{articleId}")
    ResponseEntity<ArticleTo> deleteArticle(@PathVariable(value = "articleId") String articleId);
}
