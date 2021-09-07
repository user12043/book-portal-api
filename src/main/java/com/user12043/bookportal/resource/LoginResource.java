package com.user12043.bookportal.resource;

import com.user12043.bookportal.dto.UserDto;
import com.user12043.bookportal.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/login")
public class LoginResource {
    private LoginService loginService;

    public LoginResource(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    ResponseEntity<UserDto> login(@RequestBody UserDto credentials) {
        try {
            return ResponseEntity.ok().body(loginService.login(credentials));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(credentials);
        }
    }
}
