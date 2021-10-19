package com.example.bookstore.controller;

import com.example.bookstore.controller.request.BookStoreRequest;
import com.example.bookstore.controller.response.BookStoreResponse;
import com.example.bookstore.model.BookStore;
import com.example.bookstore.service.BookStoreService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Getter
@Setter
@RestController
@RequestMapping("/api")
@Validated

public class BookStoreController {

    private final BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    //Update parameters on bookStores
    @PutMapping(value = "/updateBook/{id}", consumes = "application/json", produces = "application/json")
    public BookStoreResponse updateBookStores(@PathVariable(value = "id") String id, @RequestBody BookStoreRequest bookRequest){
        BookStore bookStore = bookStoreService.update(id, BookStoreRequest.getBookStoreName(), BookStoreRequest.getBookStoreName());

        return new BookStoreResponse(

                bookStore.getBookStoreCity(),
                bookStore.getBookStoreName()
        );
    }
}
}



