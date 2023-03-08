package com.gmail.smaglenko.blog.service.impl;

import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.model.Color;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.repository.ArticleRepository;
import com.gmail.smaglenko.blog.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InjectorService implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public InjectorService(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        String[] names = new String[]{"Petro", "Daria", "Mariya", "Viktoria", "Anna", "Taras",
                "Veronika"};
        for (int i = 0; i < random.nextInt((10 - 5) + 1) + 5; i++) {
            User user = new User();
            user.setName(names[random.nextInt(names.length)]);
            user.setAge((int) (Math.random() * 50) + 18);
            List<Article> articles = new ArrayList<>();
            for (int j = 0; j < random.nextInt(20); j++) {
                Article article = new Article();
                article.setText("Article " + j);
                article.setColor(Color.values()[random.nextInt(Color.values().length)]);
                articles.add(article);
                articleRepository.save(article);
            }
            user.setArticles(articles);
            userRepository.save(user);
        }
    }
}
