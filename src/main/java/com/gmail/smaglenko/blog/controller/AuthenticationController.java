package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.request.UserAuthRequestDto;
import com.gmail.smaglenko.blog.dto.response.UserAuthResponseDto;
import com.gmail.smaglenko.blog.model.UserAuth;
import com.gmail.smaglenko.blog.service.AuthenticationService;
import com.gmail.smaglenko.blog.service.mapper.ResponseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ResponseDtoMapper<UserAuthResponseDto, UserAuth> responseDtoMapper;

    @PostMapping("/register")
    public UserAuthResponseDto register(@RequestBody UserAuthRequestDto dto) {
        return responseDtoMapper.mapToDto(authenticationService
                .register(dto.getUsername(), dto.getPassword()));
    }
}
