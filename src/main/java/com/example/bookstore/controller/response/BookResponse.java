package com.example.bookstore.controller.response;


import com.example.bookstore.model.BookStore;
import com.example.bookstore.model.BookType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Document
@Data

public class BookResponse
{
    private String id;
    private String bookTitle;
    private String bookAuthor;
    private String bookType;
    private String bookStoreName;
    private String bookStoreCity;



}
