package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.request.ArticleRequestDto;
import com.gmail.smaglenko.blog.dto.response.ArticleResponseDto;
import com.gmail.smaglenko.blog.service.mapper.ArticleDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleDtoMapper articleDtoMapper;

    @PostMapping("/save")
    public ArticleResponseDto save(ArticleRequestDto articleRequestDto) {
        return articleDtoMapper.mapToDto(articleDtoMapper.mapToModel(articleRequestDto));
    }
}
