package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.request.ArticleRequestDto;
import com.gmail.smaglenko.blog.dto.response.ArticleResponseDto;
import com.gmail.smaglenko.blog.model.Article;
import com.gmail.smaglenko.blog.service.impl.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blog.service.impl.mapper.ResponseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final RequestDtoMapper<ArticleRequestDto, Article> requestDtoMapper;
    private final ResponseDtoMapper<ArticleResponseDto, Article> responseDtoMapper;


    @PostMapping("/save")
    public ArticleResponseDto save(ArticleRequestDto articleRequestDto) {
        return responseDtoMapper.mapToDto(requestDtoMapper.mapToModel(articleRequestDto));
    }
}
