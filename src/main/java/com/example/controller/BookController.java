package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Book;
import com.example.service.BookServices;

public class BookController {
	
	 @Autowired
	    private BookServices bookService;

	    @PostMapping
	    public ResponseEntity<Book> createBook(@RequestBody Book book) {
	        return ResponseEntity.status(201).body(bookService.saveBook(book));
	    }

	    @GetMapping
	    public List<Book> getAllBooks() {
	        return bookService.getAllBooks();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
	        return bookService.getBookById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.status(404).build());
	    }

	    @GetMapping("/author/{authorId}")
	    public List<Book> getBooksByAuthorId(@PathVariable Long authorId) {
	        return bookService.getBooksByAuthorId(authorId);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
	        bookService.deleteBookById(id);
	        return ResponseEntity.status(204).build();
	    }

}
