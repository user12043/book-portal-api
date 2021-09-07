package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.UserDto;
import com.user12043.bookportal.model.User;
import com.user12043.bookportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        return UserDto.fromUserList(userRepository.findAll());
    }

    public UserDto saveUser(UserDto userDto) {
        final User saved = userRepository.save(UserDto.toUser(userDto));
        return UserDto.fromUser(saved);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
