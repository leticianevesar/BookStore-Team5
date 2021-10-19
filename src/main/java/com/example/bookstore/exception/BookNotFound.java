
//BookNotFound
package com.example.bookstore.exception;

public class BookNotFound extends RuntimeException {

    public BookNotFound() {
        super("Product not found.");
    }

    public BookNotFound(String message) {
        super(message);
    }
}

