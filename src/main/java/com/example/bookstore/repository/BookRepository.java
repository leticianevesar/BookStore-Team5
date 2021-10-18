package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public interface BookRepository  {
    Optional<Book> findByBookId(String bookTitle);

    void save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    void deleteById(Long aLong);
}
