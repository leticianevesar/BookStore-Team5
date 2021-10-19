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
@Table(name = "Store")

public class BookStore {
    @Id
    private String id;
    @NotBlank (message = "Name is mandatory")
    @Column(name = "name")
    private String bookStoreName;

    @Column(name = "city")
    private String bookStoreCity;


}
