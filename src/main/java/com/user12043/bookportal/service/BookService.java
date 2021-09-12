package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.BookDto;
import com.user12043.bookportal.model.Book;
import com.user12043.bookportal.model.User;
import com.user12043.bookportal.repository.BookRepository;
import com.user12043.bookportal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
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

    @Transactional
    public List<BookDto> findByName(String name) {
        return BookDto.fromBookList(bookRepository.findByNameContainingIgnoreCase(name));
    }

    @Transactional
    public Set<BookDto> findReadListOfUser(Long userId) {
        final User user = userRepository.findById(userId).orElseThrow();
        return BookDto.fromBookSet(user.getReadList());
    }

    @Transactional
    public Set<BookDto> findFavouriteListOfUser(Long userId) {
        final User user = userRepository.findById(userId).orElseThrow();
        return BookDto.fromBookSet(user.getFavouriteList());
    }
}
