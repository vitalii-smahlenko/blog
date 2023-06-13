package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.UserDto;
import com.gmail.smaglenko.blog.exception.AuthenticationException;
import com.gmail.smaglenko.blog.service.AuthenticationService;
import com.gmail.smaglenko.blog.service.mapper.UserDtoMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserDtoMapper mapper;

    @ApiOperation(value = "User registration",
            response = UserDto.class)
    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto dto, Model model) {
        return mapper.mapToDto(authService
                .register(dto.getUsername(), dto.getPassword()));

    }

    @ApiOperation(value = "User login",
            response = UserDto.class)
    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto dto, Model model) throws AuthenticationException {
        return mapper.mapToDto(authService.login(dto.getUsername(), dto.getPassword()));
    }
}
