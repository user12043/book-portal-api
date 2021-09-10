package com.user12043.bookportal.repository;

import com.user12043.bookportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    List<User> findByRole(String role);

    User findByEmailAndPassword(String username, String password);

    List<User> findByNameContainingIgnoreCase(String name);
}
