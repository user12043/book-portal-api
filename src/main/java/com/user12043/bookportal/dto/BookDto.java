package com.user12043.bookportal.dto;

import com.user12043.bookportal.model.Book;

import java.util.List;

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

    public static Book toBook(BookDto bookDto) {
        Book book = new Book();
        book.setBookId(bookDto.getBookId());
        book.setName(bookDto.getName());
        book.setAuthor(AuthorDto.toAuthor(bookDto.getAuthor()));
        return book;
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
