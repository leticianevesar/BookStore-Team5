package com.example.bookstore.repository;


import com.example.bookstore.model.BookStore;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@EnableMongoRepositories

public interface BookStoreRepository extends MongoRepository<BookStore, String> {

    //Optional<BookStore> findByBookStoreName (String bookStoreName);

}
