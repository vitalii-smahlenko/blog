package com.gmail.smaglenko.blog.repository;

import com.gmail.smaglenko.blog.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    UserAuth findByUsername(String username);
}
