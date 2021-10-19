package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public interface BookRepository  extends MongoRepository <Book, String> {
    Optional<Book> findByBookTitle (String bookTitle);

//    void save(Book book);
//
//    List<Book> findAll();
//
//    Optional<Book> findById(Long id);
//
//    void deleteById(Long aLong);
}
