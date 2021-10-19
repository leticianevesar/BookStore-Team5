package com.example.library.controller.request;


import com.example.library.model.BookStore;
import com.example.library.model.BookType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class BookRequest
{
    private String bookTitle;
    private String bookAuthor;
    @Enumerated(EnumType.STRING)
    private BookType bookType; //VERIFY IF IT'S POSSIBLE?????????????
    private BookStore bookStoreName;
    private BookStore bookStoreCity;
}
