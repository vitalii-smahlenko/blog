package com.gmail.smaglenko.blog.service;

import com.gmail.smaglenko.blog.exception.AuthenticationException;
import com.gmail.smaglenko.blog.model.UserAuth;

public interface AuthenticationService {
    UserAuth register(String name, String password);

    UserAuth login(String username, String password) throws AuthenticationException;
}
