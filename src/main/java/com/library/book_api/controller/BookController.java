package com.library.book_api.controller;

import com.library.book_api.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> getBooks() {
        return books;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        book.setId((long)(books.size() + 1));
        books.add(book);
        return book;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable long id){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getId()==id){
                return books.get(i);
            }
        }
        return null;
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        // books 리스트에서 id가 일치하는 책을 삭제
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                break;
            }
        }
    }
}
