package com.gmail.smaglenko.blog.service;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.Color;
import com.gmail.smaglenko.blog.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllByAgeAfter(int age);

    List<String> getUsersWithUniqueNameAndMoreThanThreeArticle();

    User save(User user);

    List<User> getUsersWithArticleColor(Color color);

    User addArticleToUser(Long userId, Article article);
}
