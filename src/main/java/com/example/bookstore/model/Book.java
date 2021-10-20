package com.example.bookstore.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder

public class Book {

    @Id
    private String id;

    @NotBlank(message = "Title name is mandatory")
    //@Column(name = "title")
    private String bookTitle;

    //@Column(name = "author")
    private String bookAuthor;

    private BookType bookType; //VERIFY IF IT'S POSSIBLE

    private BookStore bookStoreName;

    private BookStore bookStoreCity;

    //@Indexed(unique = true)
    //private String address;
}
