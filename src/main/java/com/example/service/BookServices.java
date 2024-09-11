package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;


@Service
public class BookServices {
	
	
	 @Autowired
	    private BookRepository bookRepository;

	    @Autowired
	    private AuthorRepository authorRepository;

	    public Book saveBook(Book book) {
	        if (bookRepository.existsByIsbn(book.getIsbn())) {
	            throw new IllegalArgumentException("Book with ISBN already exists");
	        }
	        return bookRepository.save(book);
	    }

	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();
	    }

	    public Optional<Book> getBookById(Long id) {
	        return bookRepository.findById(id);
	    }

	    public List<Book> getBooksByAuthorId(Long authorId) {
	        return bookRepository.findByAuthorId(authorId);
	    }

	    public void deleteBookById(Long id) {
	        bookRepository.deleteById(id);
	    }

}
