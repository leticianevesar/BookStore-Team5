package com.example.bookstore.controller.response;

import com.example.bookstore.model.BookStore;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Document
@Data

public class BookStoreResponse {
    private String id;
    private String bookStoreName;
    private String bookStoreCity;

    public BookStoreResponse bookStoreResponseService(BookStore bookStore) {
        this.id = bookStore.getId();
        this.bookStoreName = bookStore.getBookStoreName();
        this.bookStoreCity = bookStore.getBookStoreCity();
        return this;
    }
}
