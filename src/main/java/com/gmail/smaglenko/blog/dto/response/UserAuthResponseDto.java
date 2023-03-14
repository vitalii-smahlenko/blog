package com.gmail.smaglenko.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthResponseDto {
    private Long id;
    private String username;
}
