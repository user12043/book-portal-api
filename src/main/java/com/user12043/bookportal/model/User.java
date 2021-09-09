package com.user12043.bookportal.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String name = "";

    @Column
    private String email = "";

    @Column(nullable = false, length = 5)
    private String role = "USER";

    @ManyToMany(targetEntity = Book.class)
    private List<Book> readList;

    @ManyToMany(targetEntity = Book.class)
    private List<Book> favouriteList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.username);
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

    public void setRole(String role) {
        this.role = role;
    }

    public List<Book> getReadList() {
        return readList;
    }

    public void setReadList(List<Book> readList) {
        this.readList = readList;
    }

    public List<Book> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(List<Book> favouriteList) {
        this.favouriteList = favouriteList;
    }
}
