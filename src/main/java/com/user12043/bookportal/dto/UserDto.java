package com.user12043.bookportal.dto;

import com.user12043.bookportal.model.User;

import java.util.List;

public class UserDto {
    private Long userId;

    private String username;

    private String password;

    private String name;

    private String email;

    private String role;

    public UserDto(Long userId, String username, String password, String name, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getRole());
    }

    public static List<UserDto> fromUserList(List<User> userList) {
        return userList.stream().map(UserDto::fromUser).toList();
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return user;
    }

    public static List<User> toUserDtoList(List<UserDto> userList) {
        return userList.stream().map(UserDto::toUser).toList();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String isAdmin) {
        this.role = isAdmin;
    }
}
