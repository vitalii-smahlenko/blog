package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.request.UserRequestDto;
import com.gmail.smaglenko.blog.dto.response.UserResponseDto;
import com.gmail.smaglenko.blog.model.Color;
import com.gmail.smaglenko.blog.service.ArticleService;
import com.gmail.smaglenko.blog.service.UserService;
import com.gmail.smaglenko.blog.service.mapper.ArticleDtoMapper;
import com.gmail.smaglenko.blog.service.mapper.UserDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ArticleService articleService;
    private final UserDtoMapper userDtoMapper;
    private final ArticleDtoMapper articleDtoMapper;

    public UserController(UserService userService, ArticleService articleService,
                          UserDtoMapper userDtoMapper,
                          ArticleDtoMapper articleDtoMapper) {
        this.userService = userService;
        this.articleService = articleService;
        this.userDtoMapper = userDtoMapper;
        this.articleDtoMapper = articleDtoMapper;
    }

    @PostMapping("/save")
    public UserResponseDto save(@RequestBody UserRequestDto userRequestDto) {
        userRequestDto.getArticles().forEach(articleService::save);
        return userDtoMapper.mapToDto(userService.save(userDtoMapper.mapToModel(userRequestDto)));
    }

    @GetMapping("/getAllByAgeAfter")
    public List<UserResponseDto> getAllByAgeAfter(@RequestParam int age) {
        return userService.getAllByAgeAfter(age).stream()
                .map(userDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getAllByArticleColor")
    public List<UserResponseDto> getUsersWithArticleColor(@RequestParam Color color) {
        return userService.getUsersWithArticleColor(color).stream()
                .map(userDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getUsersWithUniqueName")
    public List<String> getUsersWithUniqueNameAndMoreThanThreeArticle() {
        return userService.getUsersWithUniqueNameAndMoreThanThreeArticle();
    }
}
