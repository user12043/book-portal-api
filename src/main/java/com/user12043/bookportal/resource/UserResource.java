package com.user12043.bookportal.resource;

import com.user12043.bookportal.dto.UserDto;
import com.user12043.bookportal.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserDto> findAll() {
        return userService.findAll();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @DeleteMapping("/{userId}")
    void delete(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }
}
