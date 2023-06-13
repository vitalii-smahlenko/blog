package com.gmail.smaglenko.blog.service;

import com.gmail.smaglenko.blog.exception.AuthenticationException;
import com.gmail.smaglenko.blog.model.User;

public interface AuthenticationService {
    User register(String username, String password);

    User login(String username, String password) throws AuthenticationException;
}
