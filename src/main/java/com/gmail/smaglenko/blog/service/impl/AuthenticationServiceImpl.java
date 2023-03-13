package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.UserAuth;
import com.gmail.smaglenko.blog.model.Role;
import com.gmail.smaglenko.blog.service.AuthenticationService;
import com.gmail.smaglenko.blog.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserAuthService userAuthService;

    @Override
    public UserAuth register(String name, String password) {
        UserAuth userAuth = new UserAuth();
        userAuth.setUsername(name);
        userAuth.setPassword(password);
        userAuth.getRoles().add(Role.USER);
        return userAuthService.save(userAuth);
    }
}
