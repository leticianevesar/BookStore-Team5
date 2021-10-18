package com.example.bookstore.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Table

public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotBlank (message = "Name is mandatory")
    @Column(name = "name")
    private String bookStoreName;

    @Column(name = "city")
    private String bookStoreCity;


}
