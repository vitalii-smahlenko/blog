package com.gmail.smaglenko.blog.repository;

import com.gmail.smaglenko.blog.model.Article;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Long> {
    List<Article> findAllByOrderByIdDesc();
}
