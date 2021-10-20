package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> findByBookAuthor(String author);

}
