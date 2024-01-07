package com.redis.sid.rediscaching.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.redis.sid.rediscaching.entity.Book;
import com.redis.sid.rediscaching.repository.BookRepository;


@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // @Autowired
    // CacheManager cacheManager;

    @Cacheable(value="Books")
    public List<Book> getAllBooks() {
        System.out.println("Triggering database");
        return bookRepository.findAll();
    }

    @CacheEvict(value = "Books", allEntries = true)
    @Scheduled(fixedRateString = "${caching.spring.bookListTTL}")
    // @Scheduled(fixedRate = 6000)
    public void emptyHotelsCache() {
        System.out.println("emptying Books cache");
        // cacheManager.getCache("Books").clear();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    public boolean deleteBookById(int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Other business logic related to books
}

