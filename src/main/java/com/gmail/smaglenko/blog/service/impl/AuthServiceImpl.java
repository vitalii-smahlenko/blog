package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public User register(String name, String password) {
        return null;
    }
}
