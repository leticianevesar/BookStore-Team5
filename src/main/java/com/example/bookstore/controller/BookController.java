package com.example.bookstore.controller;

import com.example.bookstore.controller.request.BookRequest;
import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.BookStoreService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class BookController {

    private final BookService bookService;
    private final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }


    @GetMapping("/books")
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookResponse> booksResponse = new ArrayList<>();
        for (Book book : books) {
            booksResponse.add(
                    new BookResponse().bookResponseService(book)
            );
        }
        return booksResponse;
    }

    @GetMapping("/get-book-by-id/{id}")
    public BookResponse getBookById(@PathVariable(value = "id") String id) {
        Book book = bookService.findById(id);

        return new BookResponse().bookResponseService(book);
    }

    //Make GetMapping Find By Author

    @GetMapping("/get-book-by-author/{bookAuthor}")
    public BookResponse getBookByBookAuthor(@PathVariable(value = "author") String bookAuthor) {
        Book book = bookService.findByBookAuthor(bookAuthor);

        return new BookResponse().bookResponseService(book);
    }

    @PostMapping(value = "book-create")
    public BookResponse addBook(@RequestBody @Valid BookRequest bookRequest) {
        Book newBook = bookService.save(
                Book.builder()
                        .bookTitle(bookRequest.getBookTitle())
                        .bookAuthor(bookRequest.getBookAuthor())
                        .bookType(bookRequest.getBookType())
                        .build());

        return new BookResponse().bookResponseService(newBook);
    }

    @PutMapping(value = "/update-book/{id}")

    public BookResponse updateBook(@PathVariable(value = "id") String id, @RequestBody BookRequest bookRequest) {
        Book book = bookService.update(
                id,
                bookRequest);
        return new BookResponse().bookResponseService(book);
    }

    @DeleteMapping(value = "/delete-book/{id}")
    public void deleteBook(@PathVariable(value = "id") String id) {
        bookService.deleteById(id);
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
