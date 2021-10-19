package com.example.bookstore.exception;

public class DuplicateBookException extends RuntimeException
{
    public DuplicateBookException()
    {
        super("Book with this address already exists");
    }
    public DuplicateBookException(String message)
    {
        super (message);
    }
}
