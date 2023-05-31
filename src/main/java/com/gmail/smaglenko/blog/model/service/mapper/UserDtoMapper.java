package com.gmail.smaglenko.blog.model.service.mapper;

import com.gmail.smaglenko.blog.dto.UserDto;
import com.gmail.smaglenko.blog.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    @Mapping(target = "id", ignore = true)
    User mapToModel(UserDto dto);

    @Mapping(target = "password", ignore = true)
    UserDto mapToDto(User user);
}
