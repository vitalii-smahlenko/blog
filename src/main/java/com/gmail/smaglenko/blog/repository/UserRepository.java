package com.gmail.smaglenko.blog.repository;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Aggregation(pipeline = {
            "{$match: {username: ?0}}",
            "{$lookup: {from: 'articles', localField: 'id', foreignField: 'user.id', as: 'articles'}}",
            "{$unwind: '$articles'}",
            "{$replaceRoot: {newRoot: '$articles'}}"
    })
    List<Article> findArticlesByUsername(String username);
}
