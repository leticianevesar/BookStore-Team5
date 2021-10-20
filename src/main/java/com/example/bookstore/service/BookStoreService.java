package com.example.bookstore.service;

import com.example.bookstore.exception.BookStoreNotFound;
import com.example.bookstore.model.Book;
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
        return bookStoreRepository.findAll();
    }

    public BookStore findById(String id) {

        return bookStoreRepository.findById(id).orElseThrow(BookStoreNotFound::new);
    }

    public BookStore save(BookStore newBookStore) {
        return bookStoreRepository.save(newBookStore);
    }

    public BookStore update(String id, String bookStoreName, String bookStoreCity) {
        BookStore bookStore = this.findById(id);
        bookStore.setBookStoreName(bookStoreName);
        bookStore.setBookStoreCity(bookStoreCity);

        return bookStoreRepository.save(bookStore);
    }

    public void deleteById (String id) {
        this.findById(id);
        bookStoreRepository.deleteById(id);
    }
}