package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Author;
import com.example.repository.AuthorRepository;


@Service
public class AuthorServices {
	
	 @Autowired
	    private AuthorRepository authorRepository;

	    public Author saveAuthor(Author author) {
	        return authorRepository.save(author);
	    }

	    public List<Author> getAllAuthors() {
	        return authorRepository.findAll();
	    }

	    public Optional<Author> getAuthorById(Long id) {
	        return authorRepository.findById(id);
	    }

	    public void deleteAuthorById(Long id) {
	        authorRepository.deleteById(id);
	    }

}
