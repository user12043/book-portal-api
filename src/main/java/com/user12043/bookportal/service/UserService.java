package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.UserDto;
import com.user12043.bookportal.model.Book;
import com.user12043.bookportal.model.User;
import com.user12043.bookportal.repository.BookRepository;
import com.user12043.bookportal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return UserDto.fromUserList(userRepository.findAll());
    }

    @Transactional
    public UserDto save(UserDto userDto) {
        final User saved = userRepository.save(UserDto.toUser(userDto));
        return UserDto.fromUser(saved);
    }

    @Transactional
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public List<UserDto> findByName(String name) {
        return UserDto.fromUserList(userRepository.findByNameContainingIgnoreCase(name));
    }

    @Transactional
    public UserDto toggleReadList(Long bookId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (user.getReadList().contains(book)) {
            user.getReadList().remove(book);
        } else {
            user.getReadList().add(book);
        }
        User saved = userRepository.save(user);
        return UserDto.fromUser(saved);
    }

    @Transactional
    public UserDto toggleFavouriteList(Long bookId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (user.getFavouriteList().contains(book)) {
            user.getFavouriteList().remove(book);
        } else {
            user.getFavouriteList().add(book);
        }
        User saved = userRepository.save(user);
        return UserDto.fromUser(saved);
    }
}
