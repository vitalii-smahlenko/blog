package com.gmail.smaglenko.blog.dto.request;

import com.gmail.smaglenko.blog.model.Color;
import lombok.Data;

@Data
public class ArticleRequestDto {
    private String text;
    private Color color;
}
