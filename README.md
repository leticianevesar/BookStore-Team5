# Bookstore SpringBoot API with MongoDB - Backend Bootcamp Group 5

This document provides an example of a Bookstore REST API.

Main features:
- Manage your bookstore by city.
- Add/Update/Delete books by ID.
- Add new bookstores.

# CRUD Methods

## book-controller

| HTTP METHOD | GET              |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | CREATE          
| ​/api/books       		   	  | Get all books
| ​/api​/getBookById​/{bookAuthor}  | Get book by author           
| ​​/api​/getBookById​/{id}  		 | Get book by ID 

| HTTP METHOD | CREATE           |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | POST          
| ​​/api​/book-create     		    | Create a new book

| HTTP METHOD | UPDATE           |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | PUT          
| ​​​/api​/updatebook​/{id}    		    | Update book by ID

| HTTP METHOD | DELETE           |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | DELETE          
| ​​​​/api​/deleteBook​/{id}    	   | Delete book by ID


## book-store-controller

| HTTP METHOD | GET              |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | CREATE          
| ​/api/bookStores       		  | Get all bookstores
| /api/getBookStoreById/{id}     | Get bookstores by ID        

| HTTP METHOD | CREATE           |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | POST          
| ​​/api/bookStore-create     	   | Add a new bookstore

| HTTP METHOD | UPDATE           |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | PUT          
| ​​​/api/updateBookStore/{id}     | Update bookstore by ID

| HTTP METHOD | DELETE           |
| ----------- | ---------------  | 
| CRUD OP	  			 	     | DELETE          
| ​​​​/api/deleteBookStore/{id}    	 | Delete bookstore by ID
