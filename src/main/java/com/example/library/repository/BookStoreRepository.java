package com.example.library.repository;


import com.example.library.model.BookStore;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
@EnableMongoRepositories

public interface BookStoreRepository extends MongoRepository<BookStore, String> {

    Optional<BookStore> findByBookStoreName (String bookStoreName);

}
