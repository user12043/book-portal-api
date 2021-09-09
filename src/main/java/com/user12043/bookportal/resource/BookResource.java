package com.user12043.bookportal.resource;

import com.user12043.bookportal.dto.BookDto;
import com.user12043.bookportal.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookResource {
    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookDto> findAll() {
        return bookService.findAll();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BookDto save(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }

    @DeleteMapping("/{bookId}")
    void delete(@PathVariable("bookId") Long bookId) {
        bookService.delete(bookId);
    }
}