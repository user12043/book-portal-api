package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.BookDto;
import com.user12043.bookportal.model.Book;
import com.user12043.bookportal.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<BookDto> findAll() {
        return BookDto.fromBookList(bookRepository.findAll());
    }

    @Transactional
    public BookDto save(BookDto bookDto) {
        final Book saved = bookRepository.save(BookDto.toBook(bookDto));
        return BookDto.fromBook(saved);
    }

    @Transactional
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
