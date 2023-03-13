package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.UserAuth;
import com.gmail.smaglenko.blog.repository.UserAuthRepository;
import com.gmail.smaglenko.blog.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {
    private final UserAuthRepository repository;

    @Override
    public UserAuth findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserAuth save(UserAuth userUserAuth) {
        UserAuth save = repository.save(userUserAuth);
        return save;
    }
}
