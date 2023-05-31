package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.dto.UserDto;
import com.gmail.smaglenko.blog.model.Role;
import com.gmail.smaglenko.blog.model.service.UserService;
import com.gmail.smaglenko.blog.model.service.mapper.UserDtoMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserDtoMapper mapper;

    @ApiOperation(value = "Add a role to a user by userId",
            response = UserDto.class)
    @PostMapping("/add-role-to-user")
    public UserDto addRoleToUser(@RequestParam Long userId, @RequestParam Role role) {
        return mapper.mapToDto(userService.addRoleToUser(userId, role));
    }
}
