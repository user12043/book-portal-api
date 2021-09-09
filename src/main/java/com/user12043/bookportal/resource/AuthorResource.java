package com.user12043.bookportal.resource;

import com.user12043.bookportal.dto.AuthorDto;
import com.user12043.bookportal.service.AuthorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorResource {
    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    List<AuthorDto> findAll() {
        return authorService.findAll();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorDto save(@RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }

    @DeleteMapping("/{authorId}")
    void delete(@PathVariable("authorId") Long authorId) {
        authorService.delete(authorId);
    }
}
