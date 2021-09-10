package com.user12043.bookportal.repository;

import com.user12043.bookportal.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

    List<Book> findByNameContainingIgnoreCase(String name);

    List<Book> findByReadUsersUserId(Long userId);
}
