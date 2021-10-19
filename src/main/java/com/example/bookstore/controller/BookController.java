package com.example.bookstore.controller;

import com.example.bookstore.controller.request.BookRequest;
import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Document
@RestController
@RequestMapping("/api")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookResponse> booksResponse = new ArrayList<>();
        for (Book book : books) {
            booksResponse.add(new BookResponse(
                    book.getId(),
                    book.getBookAuthor(),
                    book.getBookType(),
                    book.getBookStoreName(),
                    book.getBookStoreCity()
            ));
        }
        return booksResponse;
    }

    @GetMapping("/getBookById/{id}")
    public BookResponse getBookById(String id) {
        Book book = bookService.findById(id);

        return new BookResponse(
                book.getId(),
                book.getBookTitle(),
                book.getBookType(),
                book.getBookStoreName(),
                book.getBookStoreCity()
        );
    }


    @PostMapping(value = "book-create", consumes = "application/json", produces = "application/json")
    public BookResponse bookResponse(@RequestBody BookRequest bookRequest) {
        Book newBook = Book.builder()
                .bookTitle(bookRequest.getBookTitle())
                .bookAuthor(bookRequest.getBookAuthor())
                .bookType(bookRequest.getBookType())
                .bookStoreName(bookRequest.getBookStoreName())
                .bookStoreCity(bookRequest.getBookStoreCity())
                .build();

        bookService.save(newBook);
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBookTitle(newBook.getBookTitle());
        bookResponse.setBookAuthor(newBook.getBookAuthor());
        bookResponse.setBookType(newBook.getBookType());
        bookResponse.setBookStoreName(newBook.getBookStoreName());
        bookResponse.setBookStoreCity((newBook.getBookStoreCity()));

        return bookResponse;

        //Update parameters on books
        @PutMapping(value = "/updateBook/{id}", consumes = "application/json", produces = "application/json")
        public BookResponse updateBook(@PathVariable(value = "id") String id, @RequestBody BookRequest bookRequest){
            Book book = bookService.update(id, bookRequest.getBookTitle(), bookRequest.getBookAuthor(), bookRequest.getBookType(), bookRequest.getBookStoreCity(), bookRequest.getBookStoreName());

            return new BookResponse (
                    book.getId(),
                    book.getBookTitle(),
                    book.getBookAuthor(),
                    book.getBookType(),
                    book.getBookStoreCity(),
                    book.getBookStoreName()
            );
        }
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
