package com.redis.sid.rediscaching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redis.sid.rediscaching.entity.Book;
import com.redis.sid.rediscaching.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    
   @Autowired
   BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping
    public String deleteAllBooks() {
        bookService.deleteAllBooks();
        return "All books have been deleted successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id) {
        if (bookService.deleteBookById(id)) {
            return "Book with ID " + id + " has been deleted successfully.";
        } else {
            return "Book with ID " + id + " not found.";
        }
    }

    // Other endpoints for updating books, etc.
}

