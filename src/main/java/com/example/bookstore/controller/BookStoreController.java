package com.example.bookstore.controller;

import com.example.bookstore.controller.request.BookRequest;
import com.example.bookstore.controller.request.BookStoreRequest;
import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.controller.response.BookStoreResponse;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookStore;
import com.example.bookstore.service.BookStoreService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated

public class BookStoreController {

    private final BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }


    @GetMapping("/bookStores")
    public List<BookStoreResponse> getAllBookStores() {
        List<BookStore> bookStores = bookStoreService.findAll();
        List<BookStoreResponse> bookStoresResponse = new ArrayList<>();

        for (BookStore bookStore : bookStores) {
            bookStoresResponse.add(new BookStoreResponse(
                    bookStore.getId(),
                    bookStore.getBookStoreName(),
                    bookStore.getBookStoreCity()
            ));
        }
        return bookStoresResponse;
    }

    @GetMapping("/getBookStoreById/{id}")
    public BookStoreResponse getBookStoreById(String id) {
        BookStore bookStore = bookStoreService.findById(id);

        return new BookStoreResponse(
                bookStore.getId(),
                bookStore.getBookStoreName(),
                bookStore.getBookStoreCity()
        );
    }

    @PostMapping(value = "bookStore-create", consumes = "application/json", produces = "application/json")
    public BookStoreResponse addBookStore(@RequestBody BookStoreRequest bookStoreRequest) {
        BookStore newBookStore = BookStore.builder()
                .bookStoreName(bookStoreRequest.getBookStoreName())
                .bookStoreCity(bookStoreRequest.getBookStoreCity())
                //.address(bookRequest.getAddress()) //Experiencia
                .build();

        bookStoreService.save(newBookStore);
        BookStoreResponse bookStoreResponse = new BookStoreResponse();
        bookStoreResponse.setBookStoreName(newBookStore.getBookStoreName());
        bookStoreResponse.setBookStoreCity((newBookStore.getBookStoreCity()));

        return bookStoreResponse;
    }

    @PutMapping(value = "/updateBookStore/{id}", consumes = "application/json", produces = "application/json")

    public BookStoreResponse updateBookStore(@PathVariable(value = "id") String id, @RequestBody BookStoreRequest bookStoreRequest) {
        BookStore bookStore = bookStoreService.update(
                id,
                bookStoreRequest.getBookStoreName(),
                bookStoreRequest.getBookStoreCity()
        );
        return new BookStoreResponse(
                bookStore.getId(),
                bookStore.getBookStoreName(),
                bookStore.getBookStoreCity()
        );


        //Fazer Getmapping findall
        //Fazer e find by id
        //Fazer Putmapping - Update
        //FAzer PostMapping - create

    }

    @DeleteMapping (value = "/deleteBookStore/{id}")
    public void deleteBookStore(@PathVariable(value = "id") String id)
    {
        bookStoreService.deleteById(id);
    }
}


