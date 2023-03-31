package de.backery.backerydbproxyservice.dataaccess.repo;

import de.backery.backerydbproxyservice.dataaccess.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    ArticleEntity findByArticleId(String articleId);
}
