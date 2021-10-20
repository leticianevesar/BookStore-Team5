//ExceptionsHandler
package com.example.bookstore.exception;


import com.example.bookstore.controller.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice

//Classes of Exceptions for Skill and Summoners
public class ExceptionsHandler {
    @ExceptionHandler({BookNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(BookNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({DuplicateBookException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public HttpErrorResponse handleGenericException(DuplicateBookException exception) {
        return new HttpErrorResponse(
                409,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({BookStoreNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(BookStoreNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({DuplicateBookStoreException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public HttpErrorResponse handleGenericException(DuplicateBookStoreException exception) {
        return new HttpErrorResponse(
                409,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

//        @ExceptionHandler({SkillNotFound.class})
//        @ResponseStatus(HttpStatus.NOT_FOUND)
//        public HttpErrorResponse handleGenericException(SkillNotFound exception) {
//            return new HttpErrorResponse(
//                    404,
//                    exception.getMessage(),
//                    LocalDateTime.now()
//            );
//        }
}