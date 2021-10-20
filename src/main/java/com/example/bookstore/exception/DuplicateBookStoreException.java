package com.example.bookstore.exception;

public class DuplicateBookStoreException extends RuntimeException
{
    public DuplicateBookStoreException()
    {
        super("Book with this address already exists");
    }
    public DuplicateBookStoreException(String message)
    {
        super (message);
    }
}
