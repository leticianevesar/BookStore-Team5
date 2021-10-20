package com.example.bookstore.exception;


public class BookStoreNotFound extends RuntimeException {

    public BookStoreNotFound() {
        super("Product not found.");
    }

    public BookStoreNotFound(String message) {
        super(message);
    }
}
