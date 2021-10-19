package com.example.bookstore.service;

import com.example.bookstore.model.BookStore;
import com.example.bookstore.repository.BookStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }


    public List<BookStore> findAll() {
        return  bookStoreRepository.findAll();
    }
}
