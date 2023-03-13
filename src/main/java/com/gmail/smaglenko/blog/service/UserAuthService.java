package com.gmail.smaglenko.blog.service;

import com.gmail.smaglenko.blog.model.UserAuth;

public interface UserAuthService {
    UserAuth findByUsername(String username);

    UserAuth save(UserAuth userUserAuth);
}
