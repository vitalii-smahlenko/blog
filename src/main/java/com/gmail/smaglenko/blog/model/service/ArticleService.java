package com.gmail.smaglenko.blog.model.service;

import com.gmail.smaglenko.blog.model.Article;
import java.util.List;

public interface ArticleService {
    Article create(Long userId, String text);

    List<Article> findAllByOrderByIdDesc();

    Article update(Long articleId, String text);

    Article delete(Long articleId);

    Article like(Long articleId, Long userId);

    Article dislike(Long articleId, Long userId);
}
