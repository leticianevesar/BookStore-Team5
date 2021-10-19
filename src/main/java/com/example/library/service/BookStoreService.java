package com.example.library.service;

import com.example.library.repository.BookStoreRepository;
import org.springframework.stereotype.Service;

@Service
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }
}
