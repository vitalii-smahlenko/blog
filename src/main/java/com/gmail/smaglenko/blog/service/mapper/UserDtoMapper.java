package com.gmail.smaglenko.blog.service.mapper;

import com.gmail.smaglenko.blog.dto.request.UserRequestDto;
import com.gmail.smaglenko.blog.dto.response.UserResponseDto;
import com.gmail.smaglenko.blog.model.User;

public interface UserDtoMapper {
    UserResponseDto mapToDto(User user);
    User mapToModel(UserRequestDto dto);
}
