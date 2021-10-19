package com.example.library.service;

import com.example.library.controller.response.BookResponse;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book newBook) {
        return bookRepository.save(newBook);
    }

//    // Save listed books
//    public void saveBooks(List<Book> books) {
//        for (Book book : books) {
//            bookRepository.save(book);
//        }
//    }
//
//    // List all books
//    public List<Book> findAll() { return bookRepository.findAll(); }
//
//    // Find book by id
//    public Optional<Book> findById(Long id) {
//        return bookRepository.findById(id);
//    }
//    public Book save(Book newBook) {
//        return newBook;
//    }
//
//    // Delete books by id
//    public void deleteById(Long aLong) {
//        bookRepository.deleteById(aLong);
//    }
}
