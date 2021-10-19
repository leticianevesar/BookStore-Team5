package com.example.bookstore.service;

import com.example.bookstore.exception.BookNotFound;
import com.example.bookstore.model.BookStore;
import com.example.bookstore.repository.BookStoreRepository;
import org.springframework.stereotype.Service;

@Service
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public BookStore findById(String id) {return bookStoreRepository.findById(id).orElseThrow(BookNotFound::new);
    }

    public BookStore update(String id,String bookStoreName, String bookStoreCity) {
        BookStore bookStore = this.findById(id);

        bookStore.setBookStoreName(bookStoreName);
        bookStore.setBookStoreCity(bookStoreCity);

        return bookStoreRepository.save(bookStore);





    }



