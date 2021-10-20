package com.example.bookstore.controller;

import com.example.bookstore.controller.request.BookStoreRequest;
import com.example.bookstore.controller.response.BookStoreResponse;
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


    @GetMapping("/book-stores")
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

    @GetMapping("/get-book-store-by-id/{id}")
    public BookStoreResponse getBookStoreById(@PathVariable(value = "id") String id) {
        BookStore bookStore = bookStoreService.findById(id);

        return new BookStoreResponse().bookStoreResponseService(bookStore);

    }

    @PostMapping(value = "book-store-create")
    public BookStoreResponse addBookStore(@RequestBody BookStoreRequest bookStoreRequest) {
        BookStore newBookStore = bookStoreService.save(
                BookStore.builder()
                        .bookStoreName(bookStoreRequest.getBookStoreName())
                        .bookStoreCity(bookStoreRequest.getBookStoreCity())
                        .build());

        return new BookStoreResponse().bookStoreResponseService(newBookStore);
    }

    @PutMapping(value = "/update-book-store/{id}")

    public BookStoreResponse updateBookStore(@PathVariable(value = "id") String id, @RequestBody BookStoreRequest bookStoreRequest) {
        BookStore bookStore = bookStoreService.update(
                id,
                bookStoreRequest
        );
        return new BookStoreResponse().bookStoreResponseService(bookStore);
    }


    @DeleteMapping(value = "/delete-book-store/{id}")
    public void deleteBookStore(@PathVariable(value = "id") String id) {
        bookStoreService.deleteById(id);
    }
}


