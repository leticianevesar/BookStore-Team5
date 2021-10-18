package com.example.library.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotBlank(message = "Title name is mandatory")
    @Column(name = "title")
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @Enumerated
    private BookType bookType; //VERIFY IF IT'S POSSIBLE


}
