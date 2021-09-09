package com.user12043.bookportal.service;

import com.user12043.bookportal.dto.AuthorDto;
import com.user12043.bookportal.model.Author;
import com.user12043.bookportal.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<AuthorDto> findAll() {
        return AuthorDto.fromAuthorList(authorRepository.findAll());
    }

    public AuthorDto save(AuthorDto authorDto) {
        final Author saved = authorRepository.save(AuthorDto.toAuthor(authorDto));
        return AuthorDto.fromAuthor(saved);
    }

    public void delete(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
