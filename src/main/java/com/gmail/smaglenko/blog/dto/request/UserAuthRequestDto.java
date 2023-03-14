package com.gmail.smaglenko.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthRequestDto {
    private String username;
    private String password;
}
