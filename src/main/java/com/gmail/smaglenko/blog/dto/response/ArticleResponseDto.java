package com.gmail.smaglenko.blog.dto.response;

import com.gmail.smaglenko.blog.model.Color;
import lombok.Data;

@Data
public class ArticleResponseDto {
    private Long id;
    private String text;
    private Color color;
}
