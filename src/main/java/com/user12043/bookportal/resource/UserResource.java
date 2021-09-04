package com.user12043.bookportal.resource;

import com.user12043.bookportal.model.User;
import com.user12043.bookportal.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    List<User> findAll() {
        return userService.findAll();
    }
}
