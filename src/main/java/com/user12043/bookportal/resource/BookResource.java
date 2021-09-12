package com.user12043.bookportal.resource;

import com.user12043.bookportal.dto.BookDto;
import com.user12043.bookportal.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping("/findByName/{name}")
    List<BookDto> findByName(@PathVariable String name) {
        return bookService.findByName(name);
    }

    @GetMapping("/findReadListOfUser/{userId}")
    Set<BookDto> findReadListOfUser(@PathVariable Long userId) {
        return bookService.findReadListOfUser(userId);
    }

    @GetMapping("/findFavouriteListOfUser/{userId}")
    Set<BookDto> findFavouriteListOfUser(@PathVariable Long userId) {
        return bookService.findFavouriteListOfUser(userId);
    }
}
