package com.backend.security.Auth.Dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
