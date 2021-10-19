package com.example.library.controller.response;


import com.example.library.model.BookStore;
import com.example.library.model.BookType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter

public class BookResponse
{
    private String bookTitle;
    private String bookAuthor;
    @Enumerated(EnumType.STRING)
    private BookType bookType;
    private BookStore bookStoreName;
    private BookStore bookStoreCity;
}
