package com.example.bookstore.controller.request;


import com.example.bookstore.model.BookType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document

public class BookRequest {
    private String bookTitle;
    private String bookAuthor;
    private BookType bookType;


}
