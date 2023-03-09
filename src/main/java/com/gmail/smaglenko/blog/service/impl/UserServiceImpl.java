package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.Color;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.repository.UserRepository;
import com.gmail.smaglenko.blog.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

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
}
