package com.backend.security.Auth.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.security.Auth.Dto.AuthResponseDto;
import com.backend.security.Auth.Dto.LoginDto;
import com.backend.security.Auth.Services.AuthService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){

        //01 - Receive the token from AuthService
        String token = authService.login(loginDto);

        //02 - Set the token as a response using JwtAuthResponse Dto class
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);

        //03 - Return the response to the user
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }
}
