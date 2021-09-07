package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.UserDto;
import com.user12043.bookportal.model.User;
import com.user12043.bookportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto login(UserDto credentials) {
        final User loginUser = userRepository.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
        if (loginUser == null) {
            throw new NoSuchElementException();
        }
        return UserDto.fromUser(loginUser);
    }
}
