package com.example.library.model;

import lombok.*;
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
@Table(name = "book")
public class Book {

    @Id
    private String id;

    @NotBlank(message = "Title name is mandatory")
    @Column(name = "title")
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @Enumerated(EnumType.STRING)
    private BookType bookType; //VERIFY IF IT'S POSSIBLE

    private BookStore bookStoreName;

    private BookStore bookStoreCity;

}
