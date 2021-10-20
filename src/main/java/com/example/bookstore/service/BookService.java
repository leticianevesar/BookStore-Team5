package com.example.bookstore.service;

import com.example.bookstore.controller.request.BookRequest;
import com.example.bookstore.exception.BookNotFound;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //Autowired BookRepository
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book save(Book newBook) {

        return bookRepository.save(newBook);

    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow(BookNotFound::new);
    }


    public Book findByBookAuthor(String author) {
        return bookRepository.findByBookAuthor(author).orElseThrow(BookNotFound::new);//NOT-WORKING
    }

    public Book update(String id, BookRequest bookRequest) {
        Book book = this.findById(id);
        book.setBookTitle(bookRequest.getBookTitle());
        book.setBookAuthor(bookRequest.getBookAuthor());
        book.setBookType(bookRequest.getBookType());

        return bookRepository.save(book);
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}




