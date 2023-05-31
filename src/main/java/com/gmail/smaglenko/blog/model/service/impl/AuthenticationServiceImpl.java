package com.gmail.smaglenko.blog.model.service.impl;

import com.gmail.smaglenko.blog.exception.AuthenticationException;
import com.gmail.smaglenko.blog.model.Role;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.model.service.AuthenticationService;
import com.gmail.smaglenko.blog.model.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User register(String username, String password) {
        Optional<User> userFromDb = userService.findByUsername(username);
        if (userFromDb.isPresent()){
            throw new RuntimeException("The user with this name already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.getRoles().add(Role.USER);
        return userService.save(user);
    }

    @Override
    public User login(String username, String password) throws AuthenticationException {
        Optional<User> userFromDb = userService.findByUsername(username);
        if (userFromDb.isEmpty()
                || userFromDb.get().getPassword().equals(passwordEncoder.encode(password))) {
            throw new AuthenticationException("Incorrect username or password!!!");
        }
        return userFromDb.get();
    }
}
