package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.ArticleDto;
import com.gmail.smaglenko.blog.service.ArticleService;
import com.gmail.smaglenko.blog.service.UserService;
import com.gmail.smaglenko.blog.service.mapper.ArticleDtoMapper;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleDtoMapper articleMapper;
    private final UserService userService;

    @ApiOperation(value = "Create a article.",
            response = ArticleDto.class)
    @PostMapping("/create")
    public ArticleDto create(@RequestParam Long userId, @RequestParam String text) {
        return articleMapper.mapToDto(articleService.create(userId,text));
    }

    @ApiOperation(value = "Get all articles by ID desc",
            response = ArticleDto.class)
    @GetMapping("/all-articles-by-id-desc")
    public List<ArticleDto> getAllArticlesByOrderByIdDesc() {
        return articleService.findAllByOrderByIdDesc().stream()
                .map(articleMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Get all articles by user name",
            response = ArticleDto.class)
    @GetMapping("/find-articles-by-user-name")
    public List<ArticleDto> findAllArticlesByUsername(@RequestParam String username) {
        return userService.findArticlesByUsername(username).stream()
                .map(articleMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Update an existing article",
            response = String.class)
    @PutMapping("/update")
    public ArticleDto update(@RequestParam Long articleId, @RequestParam String text) {
        return articleMapper.mapToDto(articleService.update(articleId, text));
    }

    @ApiOperation(value = "Delete a article",
            response = String.class)
    @DeleteMapping("/delete")
    public String delete(@RequestParam Long articleId) {
        articleService.delete(articleId);
        return String.format("Note by ID %d success deleted", articleId);
    }

    @ApiOperation(value = "Like a article",
            response = ArticleDto.class)
    @PutMapping("/like")
    public ArticleDto like(@RequestParam Long articleId, @RequestParam Long userId) {
        return articleMapper.mapToDto(articleService.like(articleId, userId));
    }

    @ApiOperation(value = "Dislike a article",
            response = ArticleDto.class)
    @PutMapping("/dislike")
    public ArticleDto dislike(@RequestParam Long articleId, @RequestParam Long userId) {
        return articleMapper.mapToDto(articleService.dislike(articleId, userId));
    }
}
