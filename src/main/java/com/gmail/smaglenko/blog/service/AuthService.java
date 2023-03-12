package com.gmail.smaglenko.blog.service;

import com.gmail.smaglenko.blog.model.User;

public interface AuthService {
    User register(String name, String password);
}
