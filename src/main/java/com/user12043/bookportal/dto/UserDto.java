package com.user12043.bookportal.dto;

import com.user12043.bookportal.model.User;

import java.util.List;

public class UserDto {
    private Long userId;

    private String username;

    private String password;

    private String name;

    private String email;

    public UserDto(Long userId, String username, String password, String name, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public UserDto fromUser(User user) {
        return new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail());
    }

    public List<UserDto> fromUserList(List<User> userList) {
        return userList.stream().map(this::fromUser).toList();
    }
}
