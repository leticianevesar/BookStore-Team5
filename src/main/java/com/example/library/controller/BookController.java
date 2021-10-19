package com.example.library.controller;

import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
}















































//CRUD
//
//    // CREATE - ADD NEW BOOK
//
//    @PostMapping(value ="book-create", consumes = "application/json", produces = "application/json")
//    public Book bookCreate(@RequestBody Book book){
//        Book newBook = Book
//            .builder()
//            .bookTitle(book.getBookTitle())
//            .bookType(book.getBookType())
//            .bookAuthor(book.getBookAuthor())
//            .build();
//
//        return bookService.save(newBook);
//    }
//
//    // READ -  READ ALL BOOKS
//
//    @GetMapping("/book-list")
//    public List<Book> bookList() {
//        return bookService.findAll();
//    }
//
//    // READ - READ BOOKS BY ID
//
//    @GetMapping("/books/{id}")
//    public Book bookId(@PathVariable(value = "id") Long bookId){
//
//        return bookService.findById(bookId).get();
//    }
//
//    // UPDATE - UPDATE BOOK
//
//    @PutMapping(value ="book-update/{id}", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Book> bookUpdate(@PathVariable(value = "id") Long bookId, @RequestBody Book bookDetails){
//        Book book = bookService.findById(bookId).get();
//
//        book.setBookTitle(bookDetails.getBookTitle());
//        book.setBookType(bookDetails.getBookType());
//        book.setBookAuthor(bookDetails.getBookAuthor());
//
//        final Book bookUpdate = bookService.save(book);
//        return ResponseEntity.ok(bookUpdate);
//
//    }
//
//    // DELETE -  DELETE BOOKS BY UD
//
//    @DeleteMapping(path = "delete-book/{id}")
//    public void bookDelete(@PathVariable(value = "id") Long bookId) {
//        bookService.deleteById(bookId);
//    }
//}
