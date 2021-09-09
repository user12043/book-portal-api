package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.BookDto;
import com.user12043.bookportal.model.Book;
import com.user12043.bookportal.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> findAll() {
        return BookDto.fromBookList(bookRepository.findAll());
    }

    public BookDto save(BookDto bookDto) {
        final Book saved = bookRepository.save(BookDto.toBook(bookDto));
        return BookDto.fromBook(saved);
    }

    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
