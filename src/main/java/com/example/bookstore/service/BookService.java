package com.example.bookstore.service;

import com.example.bookstore.exception.BookNotFound;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookStore;
import com.example.bookstore.model.BookType;
import com.example.bookstore.repository.BookRepository;
import org.springframework.dao.DuplicateKeyException;
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

//        try
//        {
//            return bookRepository.save(newBook);
//        } catch (DuplicateKeyException e)
//        {
//            throw new DuplicateBookException();
//        }
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow(BookNotFound::new);
    }


    public Book findByBookAuthor(String author) {
        return bookRepository.findByBookAuthor(author).orElseThrow(BookNotFound::new);
    }

    public Book update(String id, String bookTitle, String bookAuthor, BookType bookType, BookStore bookStoreName, BookStore bookStoreCity) {
        Book book = this.findById(id);
        book.setBookTitle(bookTitle);
        book.setBookAuthor(bookAuthor);
        book.setBookType(bookType);
        book.setBookStoreName(bookStoreName);
        book.setBookStoreCity(bookStoreCity);

        return bookRepository.save(book);
    }

    public void deleteById(String id) {
        this.findById(id);
        bookRepository.deleteById(id);
    }
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

