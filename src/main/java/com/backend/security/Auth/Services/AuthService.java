package com.backend.security.Auth.Services;

import com.backend.security.Auth.Dto.LoginDto;

public interface AuthService {
 String login(LoginDto loginDto);
}
