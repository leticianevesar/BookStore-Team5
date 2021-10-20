package com.example.bookstore.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
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
    @Indexed(unique = true)
    private String bookTitle;

    private String bookAuthor;

    private BookType bookType;


}
