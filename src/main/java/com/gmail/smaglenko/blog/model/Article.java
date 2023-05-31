package com.gmail.smaglenko.blog.model;

import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "articles")
public class Article {
    @Transient
    public static final String ARTICLE_SEQUENCE = "article_sequence";
    @Id
    private Long id;
    private String text;
    private int like = 0;
    @Setter(AccessLevel.NONE)
    private Set<Long> likedBy = new HashSet<>();
    @Setter(AccessLevel.NONE)
    private Set<Long> dislikedBy = new HashSet<>();
    @DBRef
    private User user;
}
