package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.UserDto;
import com.user12043.bookportal.model.User;
import com.user12043.bookportal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
