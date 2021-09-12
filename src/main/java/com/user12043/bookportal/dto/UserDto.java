package com.user12043.bookportal.dto;

import com.user12043.bookportal.model.User;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserDto {
    private Long userId;

    private String username;

    private String password;

    private String name;

    private String email;

    private String role;

    private Set<BookDto> readList;

    private Set<BookDto> favouriteList;

    public UserDto() {
    }

    public UserDto(Long userId, String username, String password, String name, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public UserDto(Long userId, String username, String password, String name, String email, String role, Set<BookDto> readList, Set<BookDto> favouriteList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.readList = readList;
        this.favouriteList = favouriteList;
    }

    public static UserDto fromUser(User user, boolean withLists) {
        final UserDto userDto = new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getRole());
        if (withLists) {
            if (user.getReadList() != null && !user.getReadList().isEmpty()) {
                userDto.setReadList(BookDto.fromBookSet(user.getReadList()));
            }
            if (user.getFavouriteList() != null && !user.getFavouriteList().isEmpty()) {
                userDto.setFavouriteList(BookDto.fromBookSet(user.getFavouriteList()));
            }
        }
        return userDto;
    }

    public static UserDto fromUser(User user) {
        return fromUser(user, false);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserDto userDto = (UserDto) o;
        if (!getUserId().equals(userDto.getUserId())) return false;
        return getUsername().equals(userDto.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername());
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

    public Set<BookDto> getReadList() {
        return readList;
    }

    public void setReadList(Set<BookDto> readList) {
        this.readList = readList;
    }

    public Set<BookDto> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(Set<BookDto> favouriteList) {
        this.favouriteList = favouriteList;
    }
}
