package com.example.bookstore.controller.response;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Document
@Data

public class BookStoreResponse
{
    private String id;
    private String bookStoreName;
    private String bookStoreCity;
}
