package com.library.book_api.controller;

import com.library.book_api.model.Book;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.book_api.repository.BookRepository;


@RestController

public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable long id){
        return bookRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
