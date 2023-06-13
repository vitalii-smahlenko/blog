package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.service.ArticleService;
import com.gmail.smaglenko.blog.service.SequenceGeneratorService;
import com.gmail.smaglenko.blog.service.UserService;
import com.gmail.smaglenko.blog.repository.ArticleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.gmail.smaglenko.blog.model.Article.ARTICLE_SEQUENCE;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserService userService;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Transactional
    @Override
    public Article create(Long userId, String text) {
        User userFromDb = userService.findById(userId);
        Article newArticle = new Article();
        newArticle.setId(sequenceGeneratorService.getSequenceNumber(ARTICLE_SEQUENCE));
        newArticle.setText(text);
        newArticle.setUser(userFromDb);
        Article articleFromDb = articleRepository.save(newArticle);
        userFromDb.getArticles().add(articleFromDb);
        userService.update(userFromDb);
        return articleFromDb;
    }

    @Override
    public List<Article> findAllByOrderByIdDesc() {
        return articleRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    @Override
    public Article update(Long articleId, String text) {
        Article articleFromDb = articleRepository.findById(articleId).orElseThrow(
                () -> new RuntimeException("Can't find article by ID " + articleId)
        );
        articleFromDb.setText(text);
        return articleRepository.save(articleFromDb);
    }

    @Transactional
    @Override
    public Article delete(Long articleId) {
        Article articleFromDb = articleRepository.findById(articleId).orElseThrow(
                () -> new RuntimeException("Can't find article by ID " + articleId)
        );
        articleRepository.delete(articleFromDb);
        return articleFromDb;
    }

    @Transactional
    @Override
    public Article like(Long articleId, Long userId) {
        Article article = articleRepository.findById(articleId).orElseThrow(
                () -> new RuntimeException("Can't find article by ID " + articleId)
        );
        if (!article.getLikedBy().contains(userId)) {
            article.setLike(article.getLike() + 1);
            article.getLikedBy().add(userId);
            article.getDislikedBy().remove(userId);
            return articleRepository.save(article);
        }
        return article;
    }

    @Transactional
    @Override
    public Article dislike(Long articleId, Long userId) {
        Article articleFromDb = articleRepository.findById(articleId).orElseThrow(
                () -> new RuntimeException("Can't find article by id " + articleId)
        );
        if (articleFromDb.getLike() > 0 && !articleFromDb.getDislikedBy().contains(userId)) {
            articleFromDb.setLike(articleFromDb.getLike() - 1);
            articleFromDb.getDislikedBy().add(userId);
            articleFromDb.getLikedBy().remove(userId);
            return articleRepository.save(articleFromDb);
        }
        return articleFromDb;
    }
}
