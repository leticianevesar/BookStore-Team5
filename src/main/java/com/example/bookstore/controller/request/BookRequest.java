package com.example.bookstore.controller.request;


import com.example.bookstore.model.BookStore;
import com.example.bookstore.model.BookType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document

public class BookRequest  {

    private String bookTitle;
    private String bookAuthor;
    private BookType bookType; //VERIFY IF IT'S POSSIBLE?????????????
    private BookStore bookStoreName;
    private BookStore bookStoreCity;
}
