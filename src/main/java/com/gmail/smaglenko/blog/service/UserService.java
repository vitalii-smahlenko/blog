package com.gmail.smaglenko.blog.service;

import com.gmail.smaglenko.blog.model.Color;
import com.gmail.smaglenko.blog.model.User;
import java.util.List;

public interface UserService {
    User findByName(String name);
    List<User> getAllByAgeAfter(int age);

    List<String> getUsersWithUniqueNameAndMoreThanThreeArticle();

    User save(User user);

    List<User> getUsersWithArticleColor(Color color);
}
