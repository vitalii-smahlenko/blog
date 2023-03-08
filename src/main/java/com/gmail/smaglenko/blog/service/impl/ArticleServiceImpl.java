package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.repository.ArticleRepository;
import com.gmail.smaglenko.blog.repository.UserRepository;
import com.gmail.smaglenko.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
