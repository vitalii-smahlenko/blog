package com.gmail.smaglenko.blog.service.impl.mapper.impl;

import com.gmail.smaglenko.blog.dto.request.UserRequestDto;
import com.gmail.smaglenko.blog.dto.response.UserResponseDto;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.service.impl.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blog.service.impl.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapperImpl implements ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRequestDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setAge(user.getAge());
        responseDto.setArticles(user.getArticles());
        return responseDto;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setArticles(dto.getArticles());
        return user;
    }
}
