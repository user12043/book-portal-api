package com.user12043.bookportal.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column
    private String name;

    @ManyToOne(targetEntity = Author.class)
    private Author author;

    @ManyToMany(targetEntity = User.class, mappedBy = "readList")
    private List<User> readUsers;

    @ManyToMany(targetEntity = User.class, mappedBy = "favouriteList")
    private List<User> favouriteUsers;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<User> getReadUsers() {
        return readUsers;
    }

    public void setReadUsers(List<User> readUsers) {
        this.readUsers = readUsers;
    }

    public List<User> getFavouriteUsers() {
        return favouriteUsers;
    }

    public void setFavouriteUsers(List<User> favouriteUsers) {
        this.favouriteUsers = favouriteUsers;
    }
}
