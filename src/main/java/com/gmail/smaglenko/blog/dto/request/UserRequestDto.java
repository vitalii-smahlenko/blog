package com.gmail.smaglenko.blog.dto.request;

import com.gmail.smaglenko.blog.model.Article;
import java.util.List;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private int age;
    private List<Article> articles;
}
