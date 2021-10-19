package com.example.bookstore.service;

import com.example.bookstore.repository.BookStoreRepository;
import org.springframework.stereotype.Service;

@Service
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }
}
