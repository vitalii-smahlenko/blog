package com.gmail.smaglenko.blog.service.mapper;

import com.gmail.smaglenko.blog.dto.request.ArticleRequestDto;
import com.gmail.smaglenko.blog.dto.response.ArticleResponseDto;
import com.gmail.smaglenko.blog.model.Article;


public interface ArticleDtoMapper {
    ArticleResponseDto mapToDto(Article article);

    Article mapToModel(ArticleRequestDto dto);
}
