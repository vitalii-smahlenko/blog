package com.gmail.smaglenko.blog.service;

import com.gmail.smaglenko.blog.model.UserAuth;
import java.util.Optional;
import javax.swing.text.html.Option;

public interface UserAuthService {
    Optional<UserAuth> findByUsername(String username);

    UserAuth save(UserAuth userUserAuth);
}
