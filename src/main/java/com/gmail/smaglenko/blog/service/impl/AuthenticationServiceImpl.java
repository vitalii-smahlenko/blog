package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.exception.AuthenticationException;
import com.gmail.smaglenko.blog.model.UserAuth;
import com.gmail.smaglenko.blog.model.Role;
import com.gmail.smaglenko.blog.service.AuthenticationService;
import com.gmail.smaglenko.blog.service.UserAuthService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserAuthService userAuthService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAuth register(String name, String password) {
        UserAuth userAuth = new UserAuth();
        userAuth.setUsername(name);
        userAuth.setPassword(password);
        userAuth.getRoles().add(Role.USER);
        return userAuthService.save(userAuth);
    }

    @Override
    public UserAuth login(String username, String password) throws AuthenticationException {
        Optional<UserAuth> userAuth = userAuthService.findByUsername(username);
        if (!userAuth.isPresent()
                || userAuth.get().getPassword().equals(passwordEncoder.encode(password))){
            throw new AuthenticationException("Incorrect username or password!!!");
        }
        return userAuth.get();
    }
}
