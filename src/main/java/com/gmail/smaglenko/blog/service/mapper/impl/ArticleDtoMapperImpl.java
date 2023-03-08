package com.gmail.smaglenko.blog.service.mapper.impl;

import com.gmail.smaglenko.blog.dto.request.ArticleRequestDto;
import com.gmail.smaglenko.blog.dto.response.ArticleResponseDto;
import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.service.mapper.ArticleDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleDtoMapperImpl implements ArticleDtoMapper {
    @Override
    public ArticleResponseDto mapToDto(Article article) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
        articleResponseDto.setId(article.getId());
        articleResponseDto.setText(article.getText());
        articleResponseDto.setColor(article.getColor());
        return articleResponseDto;
    }

    @Override
    public Article mapToModel(ArticleRequestDto articleRequestDto) {
        Article article = new Article();
        article.setText(articleRequestDto.getText());
        article.setColor(articleRequestDto.getColor());
        return article;
    }
}
