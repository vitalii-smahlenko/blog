package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.Color;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.repository.ArticleRepository;
import com.gmail.smaglenko.blog.repository.UserRepository;
import com.gmail.smaglenko.blog.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<User> getAllByAgeAfter(int age) {
        return userRepository.getAllByAgeAfter(age);
    }

    @Override
    public List<String> getUsersWithUniqueNameAndMoreThanThreeArticle() {
        return userRepository.getUsersWithUniqueNameAndMoreThanThreeArticle();
    }

    @Override
    public List<User> getUsersWithArticleColor(Color color) {
        return userRepository.getUsersWithArticleColor(color);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addArticleToUser(Long userId, Article article) {
        Article articleFromDb = articleRepository.save(article);
        User user = userRepository.findById(userId).get();
        user.getArticles().add(articleFromDb);
        return user;
    }
}
