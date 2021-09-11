package com.user12043.bookportal.dto;

import com.user12043.bookportal.model.Book;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDto {
    private Long bookId;

    private String name;

    private AuthorDto author;

    public BookDto(Long bookId, String name, AuthorDto author) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
    }

    public static BookDto fromBook(Book book) {
        return new BookDto(book.getBookId(), book.getName(), AuthorDto.fromAuthor(book.getAuthor()));
    }

    public static List<BookDto> fromBookList(List<Book> bookList) {
        return bookList.stream().map(BookDto::fromBook).toList();
    }

    public static Set<BookDto> fromBookSet(Set<Book> bookSet) {
        return bookSet.stream().map(BookDto::fromBook).collect(Collectors.toSet());
    }

    public static Book toBook(BookDto bookDto) {
        Book book = new Book();
        book.setBookId(bookDto.getBookId());
        book.setName(bookDto.getName());
        book.setAuthor(AuthorDto.toAuthor(bookDto.getAuthor()));
        return book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookDto bookDto = (BookDto) o;
        return getBookId().equals(bookDto.getBookId());
    }

    @Override
    public int hashCode() {
        return getBookId().hashCode();
    }

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

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
