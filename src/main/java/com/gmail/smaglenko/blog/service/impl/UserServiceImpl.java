package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.Role;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.service.SequenceGeneratorService;
import com.gmail.smaglenko.blog.repository.UserRepository;
import com.gmail.smaglenko.blog.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.gmail.smaglenko.blog.model.User.USER_SEQUENCE;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("Can't find user by ID " + userId)
        );
    }

    @Override
    public List<Article> findArticlesByUsername(String username) {
        return userRepository.findArticlesByUsername(username);
    }

    @Transactional
    @Override
    public User addRoleToUser(Long userId, Role role) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("Can't find user by ID " + userId)
        );
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        user.setId(sequenceGeneratorService.getSequenceNumber(USER_SEQUENCE));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
