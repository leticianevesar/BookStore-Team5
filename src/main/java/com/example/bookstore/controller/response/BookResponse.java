package com.example.bookstore.controller.response;


import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Document
@Data

public class BookResponse {
    private String id;
    private String bookTitle;
    private String bookAuthor;
    private BookType bookType;
    //private String address;

    public BookResponse bookResponseService(Book book) {
        this.id = book.getId();
        this.bookTitle = book.getBookTitle();
        this.bookAuthor = book.getBookAuthor();
        this.bookType = book.getBookType();
        return this;

    }

}
