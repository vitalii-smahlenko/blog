package com.gmail.smaglenko.blog.model.service;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.Role;
import com.gmail.smaglenko.blog.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    User findById (Long userId);

    List<Article> findArticlesByUsername(String username);


    User addRoleToUser(Long userId, Role role);

    public User update(User user);

    User save(User user);
}
