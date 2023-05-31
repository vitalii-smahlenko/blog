package com.gmail.smaglenko.blog.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
    @Transient
    public static final String USER_SEQUENCE = "user_sequence";
    @Id
    private Long id;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private List<Article> articles = new ArrayList<>();
}
