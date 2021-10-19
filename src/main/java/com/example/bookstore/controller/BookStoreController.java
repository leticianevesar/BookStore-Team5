package com.example.bookstore.controller;

import com.example.bookstore.controller.response.BookResponse;
import com.example.bookstore.controller.response.BookStoreResponse;
import com.example.bookstore.model.BookStore;
import com.example.bookstore.service.BookStoreService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<BookStoreResponse> getAllBookStores()
    {
        List<BookStore> bookStores = bookStoreService.findAll();
        List <BookStoreResponse> bookStoresResponse = new ArrayList<>();

        for (BookStore bookStore: bookStores)
        {
            bookStoresResponse.add( new BookStoreResponse(
                    bookStore.getId(),
                    bookStore.getBookStoreName(),
                    bookStore.getBookStoreCity()
            ));
        }
        return bookStoresResponse;
    }
    //Fazer Getmapping findall
    //Fazer e find by id
    //Fazer Putmapping - Update
    //FAzer PostMapping - create

}


