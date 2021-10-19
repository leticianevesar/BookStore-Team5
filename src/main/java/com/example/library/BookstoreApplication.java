package com.example.library;

import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
//
//	@Bean
//	CommandLineRunner runner(BookRepository bookRepository)
//	{
//		return args ->
//		{
//
//		};

}
