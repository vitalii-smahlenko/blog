package com.gmail.smaglenko.blog.repository;

import com.gmail.smaglenko.blog.model.Color;
import com.gmail.smaglenko.blog.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllByAgeAfter(int age);

    @Query("SELECT u FROM User u JOIN u.articles a WHERE a.color = :color")
    List<User> getUsersWithArticleColor(@Param("color") Color color);

    @Query("SELECT u.name FROM User u JOIN u.articles a GROUP BY u.name HAVING COUNT (a) > 3")
    List<String> getUsersWithUniqueNameAndMoreThanThreeArticle();
}
