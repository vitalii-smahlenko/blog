package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.request.ArticleRequestDto;
import com.gmail.smaglenko.blog.dto.response.ArticleResponseDto;
import com.gmail.smaglenko.blog.service.ArticleService;
import com.gmail.smaglenko.blog.service.mapper.ArticleDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleDtoMapper articleDtoMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleDtoMapper articleDtoMapper) {
        this.articleService = articleService;
        this.articleDtoMapper = articleDtoMapper;
    }

    @PostMapping("/save")
    public ArticleResponseDto save(ArticleRequestDto articleRequestDto) {
        return articleDtoMapper.mapToDto(articleDtoMapper.mapToModel(articleRequestDto));
    }
}
