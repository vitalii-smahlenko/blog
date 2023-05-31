package com.gmail.smaglenko.blog.dto;

import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private String text;
    private int like;
}
