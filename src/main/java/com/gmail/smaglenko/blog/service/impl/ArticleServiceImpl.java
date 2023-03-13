package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.repository.ArticleRepository;
import com.gmail.smaglenko.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
