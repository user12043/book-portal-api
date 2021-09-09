package com.user12043.bookportal.dto;

import com.user12043.bookportal.model.Author;

import java.util.List;

public class AuthorDto {
    private Long authorId;

    private String name;

    public AuthorDto(Long authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public static AuthorDto fromAuthor(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorDto(author.getAuthorId(), author.getName());
    }

    public static List<AuthorDto> fromAuthorList(List<Author> authorList) {
        return authorList.stream().map(AuthorDto::fromAuthor).toList();
    }

    public static Author toAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setAuthorId(authorDto.getAuthorId());
        author.setName(authorDto.getName());
        return author;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
