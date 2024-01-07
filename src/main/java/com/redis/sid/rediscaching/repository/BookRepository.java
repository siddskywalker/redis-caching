package com.redis.sid.rediscaching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redis.sid.rediscaching.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // You can define custom query methods here if needed
}
