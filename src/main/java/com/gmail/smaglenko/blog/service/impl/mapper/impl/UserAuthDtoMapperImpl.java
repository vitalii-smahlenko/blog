package com.gmail.smaglenko.blog.service.impl.mapper.impl;

import com.gmail.smaglenko.blog.dto.request.UserAuthRequestDto;
import com.gmail.smaglenko.blog.dto.response.UserAuthResponseDto;
import com.gmail.smaglenko.blog.model.UserAuth;
import com.gmail.smaglenko.blog.service.impl.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blog.service.impl.mapper.ResponseDtoMapper;


public class UserAuthDtoMapperImpl implements ResponseDtoMapper<UserAuthResponseDto, UserAuth>,
        RequestDtoMapper<UserAuthRequestDto, UserAuth> {
    @Override
    public UserAuthResponseDto mapToDto(UserAuth userAuth) {
        UserAuthResponseDto dto = new UserAuthResponseDto();
        dto.setId(userAuth.getId());
        dto.setUsername(userAuth.getUsername());
        return dto;
    }

    @Override
    public UserAuth mapToModel(UserAuthRequestDto dto) {
        UserAuth userAuth = new UserAuth();
        userAuth.setUsername(dto.getUsername());
        userAuth.setPassword(dto.getPassword());
        return userAuth;
    }
}
